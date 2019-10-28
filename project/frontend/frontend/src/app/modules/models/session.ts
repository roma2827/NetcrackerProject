import { Film } from "../film/models/film";
import { Hall } from "./hall";

export class Session {
  idSession: number;
  date: number;
  time: number;
  film: Film;
  hall: Hall;
}