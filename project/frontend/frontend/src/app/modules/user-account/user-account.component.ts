import {Component, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {User} from "../models/user";
import {Subscription} from "rxjs";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ticket} from "../models/ticket";
import {TicketService} from "../../services/ticket.service";

@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
})
export class UserAccountComponent implements OnInit, OnDestroy {

  public tickets: Ticket[];
  public ticket: Ticket;
  public editableT: Ticket = new Ticket();
  public password: String;
  public editableU: User = new User();
  public modalRef: BsModalRef;
  public user: User;
  private subscriptions: Subscription[] = [];

  constructor(
    private ticketService: TicketService,
    private modalService: BsModalService,
    private userService: UserService,
    private activateRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    const login = this.activateRoute.snapshot.params['login'];
    if (login) {
      this.subscriptions.push(this.userService.getUserByLogin(login).subscribe(data => {
        this.user = data;
      }));
    }
    this._getTicketByLogin(login);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  public _getTicketByLogin(login): void {
   this.subscriptions.push(this.userService.getTicketByLogin(login).subscribe(data => {
     this.tickets = data as Ticket[];
   }));
  }

  // Change Password
  public _closeChangePasswordModal(): void {
    this.modalRef.hide();
  }

  public _openChangePasswordModal(passwordTemplate: TemplateRef<any>, user: User): void {
    if (user) {
      this.editableU = user;
    }
    this.modalRef = this.modalService.show(passwordTemplate);
  }

  public _changePassword(password): void {
    this.subscriptions.push(this.userService.updatePassword(this.user.idUser, password).subscribe(() => {
      this._closeChangePasswordModal();
      this._updateUserAccount();
      this.refreshPassword();
    }));
  }

  public _updateUserAccount(): void {
    this.loadUserAccount();
  }

  private refreshPassword(): void {
    this.password = null;
  }

  private loadUserAccount(): void {
    this.ngOnInit();
  }


  // Ticket
  public _closeTicketInfoModal(): void {
    this.modalRef.hide();
  }

  public _openTicketInfoModal(ticketInfoTemplate: TemplateRef<any>, ticket: Ticket): void {
    if (ticket) {
      this.editableT = ticket;
    }
    this.modalRef = this.modalService.show(ticketInfoTemplate);
  }

  public _deleteTicket(): void {
    this.subscriptions.push(this.ticketService.deleteTicket(this.editableT.idTicket).subscribe(() => {
      this._closeTicketInfoModal();
      this._updateUserAccount();
      this.refreshT();
    }));
  }

  private refreshT(): void {
    this.editableT = new Ticket();
  }
}
