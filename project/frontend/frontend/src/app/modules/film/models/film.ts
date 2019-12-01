import {Session} from "../../models/session";

export class Film {
  filmId: number;
  name: string;
  description: string;
  time: number;
  films: Set<Session>;
  imj: string;
}
