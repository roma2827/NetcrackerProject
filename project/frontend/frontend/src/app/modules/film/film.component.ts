import {Component, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {Film} from './models/film'
import {Subscription} from 'rxjs';
import {FilmService} from '../../services/film.service'
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {StorageService} from "../../services/storage.service";

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ["./film.component.css"]
})
export class FilmComponent implements OnInit, OnDestroy {

  public films: Film[];
  private subscriptions: Subscription[] = [];
  public editableF: Film = new Film();
  public modalRef: BsModalRef;

  constructor(
    private storageService: StorageService,
    private modalService: BsModalService,
    private filmService: FilmService
  ) {}


  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  ngOnInit() {
    this.loadFilms();
  }


  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public _addFilm(): void {
    this.subscriptions.push(this.filmService.saveFilm(this.editableF).subscribe(() => {
      this._updateFilms();
      this.refreshF();
      this._closeModal();
    }));
  }

  public _updateFilms(): void {
    this.loadFilms();
  }

  private refreshF(): void {
    this.editableF = new Film();
  }

  private loadFilms(): void {
    this.subscriptions.push(this.filmService.getFilms().subscribe(data => {
      this.films = data as Film[];
    }));
  }
}
