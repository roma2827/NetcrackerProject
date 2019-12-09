import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { User } from "../modules/models/user";
import {Ticket} from "../modules/models/ticket";
import {LoginModel} from "../modules/models/login.model";


@Injectable()
// Data service
export class UserService {

  constructor(private http: HttpClient) {
  }

  // public generateToken(login: LoginModel): Observable<AuthToken> {
  //   return this.http.post<AuthToken>("/api/token/generate-token", login);
  // }

  // Ajax request for billing account data
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/user');
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api/user', user);
  }

  deleteUser(idUser: number): Observable<void> {
    return this.http.delete<void>('/api/user/' + idUser);
  }

  getUserByLogin(login: string): Observable<User> {
    return this.http.get<User>('/api/user/login/' + login);
  }

  updatePassword(idUser: number, password: String): Observable<User> {
    return this.http.post<User>('/api/user/update-password/' + idUser, password);
  }

  getTicketByIdUser(idUser: number): Observable<Ticket[]> {
    return this.http.get<Ticket[]>('/api/user/ticket/' + idUser);
  }

  getTicketByLogin(login: string): Observable<Ticket[]> {
    return this.http.get<Ticket[]>("/api/user/ticketByLogin/" + login);
  }

  public generateToken(login: LoginModel): Observable<AuthToken> {
    return this.http.post<AuthToken>("/api/token/generate-token", login);
  }

  public getAuthorizedUser(): Observable<User> {
    return this.http.get<User>("/api/user/current");
  }
}

export interface AuthToken {
  readonly token: string;
}
