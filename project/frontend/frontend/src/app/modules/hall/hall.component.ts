import {Component, OnInit, Input, TemplateRef, OnDestroy} from "@angular/core";
import {Hall} from "../models/hall";
import { ActivatedRoute, Router } from "@angular/router";
import { Subscription } from "rxjs";
import {SessionService} from "../../services/session.service";
import {HallService} from "../../services/hall.service";
import {Place} from "../models/place";
import {PlaceService} from "../../services/place.service";
import {User} from "../models/user";
import {Film} from "../film/models/film";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ticket} from "../models/ticket";
import {TicketService} from "../../services/ticket.service";
import {Session} from "../models/session";
import {StorageService} from "../../services/storage.service";

@Component({
  selector: "app-hall",
  templateUrl: "./hall.component.html",
  styleUrls: ["./hall.component.css"]
})
export class HallComponent implements OnInit, OnDestroy {

  public editTicketMode = false;

  public editableT: Ticket = new Ticket();
  public modalTicketRef: BsModalRef;
  public film: Film;
  public session: Session;
  public place: Place;
  public places: Place[];
  public hall: Hall;
  private subscriptions: Subscription[] = [];

  constructor(
    private storageService: StorageService,
    private ticketService: TicketService,
    private modalService: BsModalService,
    private placeService: PlaceService,
    private activateRoute: ActivatedRoute,
    private router: Router,
    private sessionService: SessionService,
  ) {}

  ngOnInit() {
    const idSession = this.activateRoute.snapshot.params["idSession"];
    if (idSession) {
      this.subscriptions.push(this.sessionService.getHallByIdSession(idSession).subscribe(data => {
        this.hall = data;
      }));
    }
    if (idSession) {
      this.subscriptions.push(this.sessionService.getPlacesByIdSession(idSession).subscribe(data => {
        this.places = data as Place[];
      }));
    }
    this._getSessionById(idSession);
    this._getFilmById(idSession);
  }

  public _getFilmById(idSession): void {
    this.subscriptions.push(this.sessionService.getFilmByIdSession(idSession).subscribe(data => {
      this.film = data;
    }));
  }

  public _getSessionById(idSession): void {
    this.subscriptions.push(this.sessionService.getSessionById(idSession).subscribe(data => {
      this.session = data;
    }));
  }

  public getPlaceById(idPlace): void {
    this.subscriptions.push(this.placeService.getPlaceById(idPlace).subscribe(data => {
      this.place = data;
    }));
  }

  public updateIsFree(idPlace): void {
    this.subscriptions.push(this.placeService.updatePlace(idPlace).subscribe(() => {
      this.ngOnInit();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  // Ticket
  public _openTicketModal(template: TemplateRef<any>): void {

    // if (ticket) {
    //   this.editTicketMode = true;
    //   this.editableT = ticket;
    // } else {
    //   this.refreshT();
    //   this.editTicketMode = false;
    // }

    this.modalTicketRef = this.modalService.show(template);
  }

  public _closeTicketModal(): void {
    this.modalTicketRef.hide();
  }

  public _addTicket(session: Session, place: Place): void {
    this.session.film = this.film;
    this.editableT.user = this.storageService.getCurrentUser();
    this.editableT.place = place;
    this.editableT.session = session;
      this.subscriptions.push(this.ticketService.saveTicket(this.editableT).subscribe(() => {
      this._updateHall();
      this.refreshT();
      this._closeTicketModal();
    }));
  }

  public _updateHall(): void {
    this.loadHall();
  }

  private refreshT(): void {
    this.editableT = new Ticket();
  }

  private loadHall(): void {
    this.ngOnInit();
  }
}
