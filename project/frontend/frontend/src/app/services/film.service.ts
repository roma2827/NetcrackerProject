import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Film} from "../modules/film/models/film";

@Injectable()
// Data service
export class FilmService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getFilms(): Observable<Film[]> {
    return this.http.get<Film[]>('/api/films')
  }

  getFilmById(filmId: number): Observable<Film>{
    return this.http.get<Film>('api/films/id/' + filmId);
  }

  saveFilm(film: Film): Observable<Film> {
    return this.http.post<Film>('/api/films', film);
  }

  deleteFilm(filmId: number): Observable<void> {
    return this.http.delete<void>('/api/films/' + filmId);
  }

  getFilmByName(name: string): Observable<Film> {
    return this.http.get<Film>('/api/films/' + name);
  }

}