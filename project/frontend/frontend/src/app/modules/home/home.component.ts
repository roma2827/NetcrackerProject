import {Component, OnDestroy, OnInit} from '@angular/core';
import { Film } from '../film/models/film';
import { FilmService } from '../../services/film.service';
import { Subscription } from 'rxjs';
import { CinemaService} from "../../services/cinema.service";
import $ from "jquery";
import {Cinema} from "../models/cinema";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit, OnDestroy {

  cinemas: Cinema[];
  film: Film;
  films: Film[] = [];
  private subscriptions: Subscription[] = [];

  constructor(
    private cinemaService: CinemaService,
    private filmService: FilmService) {
  }

  ngOnInit() {
    this.getFilm();
    this.getFilmById(1);
    this.getCinemas();
  }

  public getFilm(): void {
    this.subscriptions.push(this.filmService.getFilms().subscribe(data => {
      this.films = data as Film[];
    }));
  }

  public getFilmById(filmId: number): void {
    this.subscriptions.push(this.filmService.getFilmById(filmId).subscribe(data => {
      this.film = data;
    }));
  }

  public getCinemas(): void {
    this.subscriptions.push(this.cinemaService.getCinemas().subscribe(data => {
      this.cinemas = data as Cinema[];
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
