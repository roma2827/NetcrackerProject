import { Component, OnInit } from '@angular/core';
import { Film } from '../film/models/film';
import { FilmService } from '../../services/film.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit {
  films: Film[] = [];
  private subscriptions: Subscription[] = [];

  constructor(private filmService: FilmService) { }

  ngOnInit() {
    this.getFilm();
  }

  public getFilm(): void{
    this.subscriptions.push(this.filmService.getFilms().subscribe(data => {
      this.films = data as Film[];
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}