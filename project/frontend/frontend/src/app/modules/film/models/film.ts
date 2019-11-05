import {Session} from "../../models/session";

export class Film {
  filmId: number;
  name: string;
  description: string;
  time: number;
  startData: number;
  endData: number;
  films: Set<Session>;
}
