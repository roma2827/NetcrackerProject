import {Component, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import {Subscription} from "rxjs/internal/Subscription";
import {Film} from "../../film/models/film"
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import { FilmService } from "src/app/services/film.service";
import {User} from "../../models/user";
import {UserService} from "../../../services/user.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"]
})
export class HeaderComponent implements OnInit, OnDestroy {

  private subscriptions: Subscription[] = [];
  public editableUs: User = new User();
  public modalRegistrationRef: BsModalRef;
  public modalSignInRef: BsModalRef;
  private exceptionText: String;

  constructor(
    private  userService: UserService,
    private modalService: BsModalService
  ) {}

  ngOnInit() {
  }

  public _closeSignInModal(): void {
    this.modalSignInRef.hide();
  }

  public _openSignInModal(template: TemplateRef<any>): void {
    this.modalSignInRef = this.modalService.show(template);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  // Registration
  public _openRegistrationModal(template: TemplateRef<any>): void {
    this.modalRegistrationRef = this.modalService.show(template);
  }

  public _closeRegistrationModal(): void {
    this.modalRegistrationRef.hide();
  }

  public _addUser(): void {
    this.subscriptions.push(this.userService.saveUser(this.editableUs).subscribe(() => {
      this.refreshUs();
      this._closeRegistrationModal();
    }));
  }

  public _login(): void {
    this.subscriptions.push(this.userService.login(this.editableUs).subscribe(data => {
      this.exceptionText = data;
      this.refreshUs();
      this._closeSignInModal();
    }));
  }

  private refreshUs(): void {
    this.editableUs = new User();
  }
}
