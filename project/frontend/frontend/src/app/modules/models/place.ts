import { Hall } from "./hall";
import {Session} from "./session";

export class Place {
  idPlace: number;
  seat: number;
  row: number;
  isFree: string;
  // hall: Hall;
  session: Session;
  price: number;

}
