import { Component, OnInit, Input, TemplateRef } from '@angular/core';
import { Film } from '../film/models/film';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import {FilmService} from '../../services/film.service';
import {Session} from '../models/session';
import {SessionService} from '../../services/session.service';
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-film-detail',
  templateUrl: './film.detail.component.html',
})
export class FilmDetailComponent implements OnInit {

  film: Film;
  public sessions: Session[];
  private subscriptions: Subscription[] = [];

  constructor(
    private activateRoute: ActivatedRoute,
    private filmService: FilmService,
    private router: Router,
    private sessionService: SessionService
  ) { }

  ngOnInit() { 
    this.getSession();
    const filmId = this.activateRoute.snapshot.params['filmId'];

    if(filmId){
      this.subscriptions.push(this.filmService.getFilmById(filmId).subscribe(data => {
        this.film = data;
      }));
    }

  }

  public getSession(): void{
    this.subscriptions.push(this.sessionService.getSessions().subscribe(data => {
      this.sessions = data as Session[];
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
  

  public _deleteFilm(filmId: number): void {
    console.log(filmId)
    this.subscriptions.push(this.filmService.deleteFilm(filmId).subscribe(() => {
      this.ngOnInit();
    }));
  }

  public _deleteSession(idSession: number): void {
    console.log(idSession)
    this.subscriptions.push(this.sessionService.deleteSession(idSession).subscribe(() => {
      this.ngOnInit();
    }));
  }
}