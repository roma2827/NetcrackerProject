import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { User } from "../modules/models/user";


@Injectable()
// Data service
export class UserService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/user')
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api/user', user);
  }

  deleteUser(idUser: number): Observable<void> {
    return this.http.delete<void>('/api/user/' + idUser);
  }

  getUserByLogin(login: string): Observable<User> {
    return this.http.get<User>('/api/user/' + login);
  }
  
}