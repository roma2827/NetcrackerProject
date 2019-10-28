import { Session } from "./session";
import { Place } from "./place";

export class Ticket {
  idTicket: number;
  session: Session;
  place: Place;
}