import {Component, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import {Subscription} from "rxjs/internal/Subscription";
import {Film} from "../../film/models/film"
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import { FilmService } from "src/app/services/film.service";
import {User} from "../../models/user";
import {UserService} from "../../../services/user.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html"
})
export class HeaderComponent implements OnInit, OnDestroy {

  public users: User[];
  public editRegistrationMode = false;
  public editMode = false;
  public films: Film[];
  private subscriptions: Subscription[] = [];
  public editableUs: User = new User();
  public editableBa: Film = new Film();
  public modalRegistrationRef: BsModalRef;
  public modalRef: BsModalRef;

  constructor(private  userService: UserService,
    private modalService: BsModalService,
    private filmService: FilmService) {}

  ngOnInit() {
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

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  // Registration
  public _openRegistrationModal(template: TemplateRef<any>, user: User): void {

    if (user) {
      this.editRegistrationMode = true;
      this.editableUs = user;
    } else {
      this.refreshUs();
      this.editRegistrationMode = false;
    }

    this.modalRegistrationRef = this.modalService.show(template);
  }

  public _closeRegistrationModal(): void {
    this.modalRegistrationRef.hide();
  }

  public _addUser(): void {
    this.subscriptions.push(this.userService.saveUser(this.editableUs).subscribe(() => {
      this._updateUsers();
      this.refreshUs();
      this._closeRegistrationModal();
    }));
  }

  public _updateUsers(): void {
    this.loadUsers();
  }

  private refreshUs(): void {
    this.editableUs = new User();
  }

  private loadUsers(): void {
    this.subscriptions.push(this.userService.getUsers().subscribe(data => {
      this.users = data as User[];
    }));
  }
}
