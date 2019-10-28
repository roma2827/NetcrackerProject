import { Component, OnInit,  TemplateRef} from "@angular/core";
import {Subscription} from "rxjs/internal/Subscription";
import {Film} from "../../film/models/film"
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import { FilmService } from "src/app/services/film.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html"
})
export class HeaderComponent implements OnInit {

  public editMode = false;

  public films: Film[];
  private subscriptions: Subscription[] = [];
  public editableBa: Film = new Film();
  public modalRef: BsModalRef;

  constructor(private modalService: BsModalService,
    private filmService: FilmService) {}

  ngOnInit() {
    this.loadFilms();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, film: Film): void {

    if (film) {
      console.log(film)
      this.editMode = true;
      this.editableBa = film;
      console.log(this.editableBa)
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

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}