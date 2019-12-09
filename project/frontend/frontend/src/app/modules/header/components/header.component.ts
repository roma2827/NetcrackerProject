import {Component, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import {Subscription} from "rxjs/internal/Subscription";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {User} from "../../models/user";
import {AuthToken, UserService} from "../../../services/user.service";
import {LoginModel} from "../../models/login.model";
import {StorageService} from "../../../services/storage.service";



@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"]
})
export class HeaderComponent implements OnInit, OnDestroy {

  public loginModel: LoginModel = {
    username: null,
    password: null
  };
  public repeatPassword: string;
  public user: User;
  private subscriptions: Subscription[] = [];
  public editableUs: User = new User();
  public modalRegistrationRef: BsModalRef;
  public modalSignInRef: BsModalRef;

  constructor(
    private  userService: UserService,
    private modalService: BsModalService,
    private storageService: StorageService
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

  public _login(): void {
    this.userService.generateToken(this.loginModel)
      .subscribe((authToken: AuthToken) => {
        if (authToken.token) {
          this.storageService.setToken(authToken.token);
          this.userService.getAuthorizedUser()
            .subscribe((user: User) => {
              this.storageService.setCurrentUser(user);
              this._closeSignInModal();
            });
        }
      }, (error) => {
        // if (error.status === 401) {
        //   this.showCheckYourSetDataAlert = true;
        // } else {
        //   alert(error.message);
        // }
      });
  }

  public logout(): void {
    this.storageService.clearToken();
    this.storageService.setCurrentUser(null);
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

  private refreshUs(): void {
    this.editableUs = new User();
  }
}
