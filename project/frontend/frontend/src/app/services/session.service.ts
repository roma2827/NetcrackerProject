import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Session } from "../modules/models/session";
import {Hall} from "../modules/models/hall";
import {Film} from "../modules/film/models/film";
import {Place} from "../modules/models/place";

@Injectable()
// Data service
export class SessionService {

  constructor(private http: HttpClient) {
  }

  getSessions(): Observable<Session[]> {
    return this.http.get<Session[]>('/api/session')
  }

  saveSession(session: Session): Observable<Session> {
    return this.http.post<Session>('/api/session', session);
  }

  deleteSession(idSession: number): Observable<void> {
    return this.http.delete<void>('/api/session/' + idSession);
  }

  getHallByIdSession(idSession: number): Observable<Hall> {
    return this.http.get<Hall>('api/session/hall/' + idSession);
  }

  getPlacesByIdSession(idSession: number): Observable<Place[]> {
    return this.http.get<Place[]>('api/session/place/' + idSession);
  }

  getSessionById(idSession: number): Observable<Session> {
    return this.http.get<Session>('/api/session/id/' + idSession);
  }

}
