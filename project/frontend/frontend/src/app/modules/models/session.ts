import { Film } from "../film/models/film";
import { Hall } from "./hall";
import {Place} from "./place";

export class Session {
  idSession: number;
  date: number;
  time: number;
  film: Film;
  hall: Hall;
  sessionsPlace: Set<Place>;

}
