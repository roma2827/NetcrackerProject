import {Component, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {Film} from './models/film'
import {Subscription} from 'rxjs';
import {FilmService} from '../../services/film.service'
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ["./film.component.css"]
})
export class FilmComponent implements OnInit, OnDestroy {

  public editMode = false;

  public films: Film[];
  private subscriptions: Subscription[] = [];

  public editableBa: Film = new Film();
  public modalRef: BsModalRef;

  constructor(private modalService: BsModalService,
              private filmService: FilmService) {
  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  ngOnInit() {
    this.loadFilms();
  }


  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, film: Film): void {
    if (film) {
      this.editMode = true;
      this.editableBa = film;
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  public _addFilm(): void {
    this.subscriptions.push(this.filmService.saveFilm(this.editableBa).subscribe(() => {
      this._updateFilms();
      this.refreshBa();
      this._closeModal();
    }));
  }

  public _updateFilms(): void {
    this.loadFilms();
  }

  private refreshBa(): void {
    this.editableBa = new Film();
  }

  private loadFilms(): void {
    this.subscriptions.push(this.filmService.getFilms().subscribe(data => {
      this.films = data as Film[];
    }));
  }


}
