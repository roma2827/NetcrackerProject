import {Component, OnInit, Input, TemplateRef, OnDestroy} from '@angular/core';
import {Film} from '../film/models/film';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {FilmService} from '../../services/film.service';
import {Session} from '../models/session';
import {SessionService} from '../../services/session.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Hall} from "../models/hall";
import {HallService} from "../../services/hall.service";
import {CinemaService} from "../../services/cinema.service";
import {Cinema} from "../models/cinema";
import {StorageService} from "../../services/storage.service";


@Component({
  selector: 'app-film-detail',
  templateUrl: './film.detail.component.html',
  styleUrls: ["./film.detail.component.css"]
})
export class FilmDetailComponent implements OnInit, OnDestroy {

  public cinemas: Cinema[];
  public halls: Hall[];
  public editSessionMode = false;
  public editableS: Session = new Session();
  public editableC: Cinema = new Cinema();
  public editableH: Hall = new Hall();
  public modalSessionRef: BsModalRef;
  public modalCinemaRef: BsModalRef;
  public modalHallRef: BsModalRef;
  public film: Film;
  public sessions: Session[];
  private subscriptions: Subscription[] = [];

  constructor(
    private storageService: StorageService,
    private cinemaService: CinemaService,
    private hallService: HallService,
    private modalService: BsModalService,
    private activateRoute: ActivatedRoute,
    private filmService: FilmService,
    private router: Router,
    private sessionService: SessionService
  ) {}

  ngOnInit() {
    const filmId = this.activateRoute.snapshot.params['filmId'];
    if (filmId) {
      this.subscriptions.push(this.filmService.getFilmById(filmId).subscribe(data => {
        this.film = data;
      }));
    }
    this._getSessions(filmId);
  }

  public _getHalls(): void {
    this.subscriptions.push(this.hallService.getHalls().subscribe(data => {
      this.halls = data as Hall[];
    }));
  }

  public _getCinemas(): void {
    this.subscriptions.push(this.cinemaService.getCinemas().subscribe(data => {
      this.cinemas = data as Cinema[];
    }));
  }

  public _getSessions(filmId: number): void {
    this.subscriptions.push(this.filmService.getSessionByFilmId(filmId).subscribe(data => {
      this.sessions = data as Session[];
    }));
  }

  public _deleteFilm(filmId: number): void {
    this.subscriptions.push(this.filmService.deleteFilm(filmId).subscribe(() => {
    }));
  }

  public _deleteSession(idSession: number): void {
    this.subscriptions.push(this.sessionService.deleteSession(idSession).subscribe(() => {
      this.ngOnInit();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  // AddSession
  public _openAddSessionModal(template: TemplateRef<any>): void {
    this.modalSessionRef = this.modalService.show(template);
  }

  public _closeSessionModal(): void {
    this.modalSessionRef.hide();
  }

  public _addSession(film: Film): void {
    this.editableS.film = film;
    this.subscriptions.push(this.sessionService.saveSession(this.editableS).subscribe(() => {
      this._updateFilmDetail();
      this.refreshS();
      this._closeSessionModal();
    }));
  }

  public _updateFilmDetail(): void {
    this.loadFilmDetail();
  }

  private refreshS(): void {
    this.editableS = new Session();
  }

  private loadFilmDetail(): void {
    this.ngOnInit();
  }

//  AddCinema
  public _openAddCinemaModal(templateAddCinema: TemplateRef<any>): void {
    this.modalCinemaRef = this.modalService.show(templateAddCinema);
  }

  public _closeCinemaModal(): void {
    this.modalCinemaRef.hide();
  }

  public _addCinema(): void {
    this.subscriptions.push(this.cinemaService.saveCinema(this.editableC).subscribe(() => {
      this._updateFilmDetail();
      this.refreshC();
      this._closeCinemaModal();
    }));
  }

  private refreshC(): void {
    this.editableC = new Cinema();
  }

//  AddHall
  public _openAddHallModal(templateAddHall: TemplateRef<any>): void {
    this.modalHallRef = this.modalService.show(templateAddHall);
  }

  public _closeHallModal(): void {
    this.modalHallRef.hide();
  }

  public _addHall(): void {
    this.subscriptions.push(this.hallService.saveHall(this.editableH).subscribe(() => {
      this._updateFilmDetail();
      this.refreshH();
      this._closeHallModal();
    }));
  }

  private refreshH(): void {
    this.editableH = new Hall();
  }
}
