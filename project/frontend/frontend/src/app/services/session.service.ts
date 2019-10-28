import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Session } from "../modules/models/session";

@Injectable()
// Data service
export class SessionService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getSessions(): Observable<Session[]> {
    return this.http.get<Session[]>('/api/session')
  }

  // getFilmById(filmId: number): Observable<Film>{
  //   return this.http.get<Film>('api/films/id/' + filmId);
  // }

  saveSession(session: Session): Observable<Session> {
    return this.http.post<Session>('/api/session', session);
  }

  deleteSession(idSession: number): Observable<void> {
    return this.http.delete<void>('/api/session/' + idSession);
  }

  // getFilmByName(name: string): Observable<Film> {
  //   return this.http.get<Film>('/api/films/' + name);
  // }

}