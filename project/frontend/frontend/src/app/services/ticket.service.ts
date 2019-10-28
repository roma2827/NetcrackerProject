import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Ticket } from "../modules/models/ticket";


@Injectable()
// Data service
export class TicketService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getTickets(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>('/api/ticket')
  }

  saveTicket(ticket: Ticket): Observable<Ticket> {
    return this.http.post<Ticket>('/api/ticket', ticket);
  }

  deleteTicket(idTicket: number): Observable<void> {
    return this.http.delete<void>('/api/ticket/' + idTicket);
  }
  
}