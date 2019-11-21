import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Cinema } from "../modules/models/cinema";
import {Session} from "../modules/models/session";
import {Hall} from "../modules/models/hall";

@Injectable()
// Data service
export class CinemaService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getCinemas(): Observable<Cinema[]> {
    return this.http.get<Cinema[]>('/api/cinema');
  }

  getCinemaById(idCinema: number): Observable<Cinema> {
    return this.http.get<Cinema>('/api/cinema/id/' + idCinema);
  }

  saveCinema(cinema: Cinema): Observable<Cinema> {
    return this.http.post<Cinema>('/api/cinema', cinema);
  }

  deleteCinema(idCinema: number): Observable<void> {
    return this.http.delete<void>('/api/cinema/' + idCinema);
  }

  getCinemaByName(name: string): Observable<Cinema> {
    return this.http.get<Cinema>('/api/cinema/' + name);
  }

  getHallsByIdCinema(idCinema: number): Observable<Hall[]> {
    return this.http.get<Hall[]>('/api/cinema/halls/' + idCinema);
  }

}
