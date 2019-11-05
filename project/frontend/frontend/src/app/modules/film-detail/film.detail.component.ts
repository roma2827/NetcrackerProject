import {Component, OnInit, Input, TemplateRef, OnDestroy} from '@angular/core';
import { Film } from '../film/models/film';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import {FilmService} from '../../services/film.service';
import {Session} from '../models/session';
import {SessionService} from '../../services/session.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Hall} from "../models/hall";
import {Place} from "../models/place";

@Component({
  selector: 'app-film-detail',
  templateUrl: './film.detail.component.html',
})
export class FilmDetailComponent implements OnInit, OnDestroy {

  film: Film;
  public sessions: Session[];
  private subscriptions: Subscription[] = [];

  constructor(
    private activateRoute: ActivatedRoute,
    private filmService: FilmService,
    private router: Router,
    private sessionService: SessionService
  ) { }

  ngOnInit() {
    const filmId = this.activateRoute.snapshot.params['filmId'];
    if(filmId){
      this.subscriptions.push(this.filmService.getFilmById(filmId).subscribe(data => {
        this.film = data;
      }));
    }
    this._getSessions(filmId);
  }

  public _getSessions(filmId: number): void {
    this.subscriptions.push(this.filmService.getSessionByFilmId(filmId).subscribe(data => {
      this.sessions = data as Session[];
    }));
  }

  public _deleteFilm(filmId: number): void {
    console.log(filmId)
    this.subscriptions.push(this.filmService.deleteFilm(filmId).subscribe(() => {
      this.ngOnInit();
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
}
