import { Session } from "./session";
import { Place } from "./place";
import {User} from "./user";

export class Ticket {
  idTicket: number;
  session: Session;
  place: Place;
  user: User;
}
