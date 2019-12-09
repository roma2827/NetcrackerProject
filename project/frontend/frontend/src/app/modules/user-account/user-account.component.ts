import {Component, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {User} from "../models/user";
import {Subscription} from "rxjs";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ticket} from "../models/ticket";
import {TicketService} from "../../services/ticket.service";
import {WalletService} from "../../services/wallet.service";
import {StorageService} from "../../services/storage.service";

@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ["./user-account.component.css"]
})
export class UserAccountComponent implements OnInit, OnDestroy {

  public tickets: Ticket[];
  public ticket: Ticket;
  public editableT: Ticket = new Ticket();
  public money: string;
  public password: String;
  public editableU: User = new User();
  public modalMoneyRef: BsModalRef;
  public modalRef: BsModalRef;
  public user: User;
  private subscriptions: Subscription[] = [];

  constructor(
    private storageService: StorageService,
    private walletService: WalletService,
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


  // Money
  public _closeMoneyModal(): void {
    this.modalMoneyRef.hide();
  }

  public _openMoneyModal(moneyTemplate: TemplateRef<any>, user: User): void {
    if (user) {
      this.editableU = user;
    }
    this.modalMoneyRef = this.modalService.show(moneyTemplate);
  }

  public _replenishmentOfFund(money): void {
    this.subscriptions.push(this.walletService.replenishmentOfFund(this.user.wallet.idWallet, money).subscribe(() => {
      this._closeMoneyModal();
      this._updateUserAccount();
      this.refreshMoney();
    }));
  }

  private refreshMoney(): void {
    this.money = null;
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
