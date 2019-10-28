import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Hall } from "../modules/models/hall";


@Injectable()
// Data service
export class HallService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getHalls(): Observable<Hall[]> {
    return this.http.get<Hall[]>('/api/hall')
  }

  getHallById(idHall: number): Observable<Hall>{
    return this.http.get<Hall>('api/hall/id/' + idHall);
  }

  saveHall(hall: Hall): Observable<Hall> {
    return this.http.post<Hall>('/api/hall', hall);
  }

  deleteHall(idHall: number): Observable<void> {
    return this.http.delete<void>('/api/hall/' + idHall);
  }

  getHallByName(name: string): Observable<Hall> {
    return this.http.get<Hall>('/api/hall/' + name);
  }

}