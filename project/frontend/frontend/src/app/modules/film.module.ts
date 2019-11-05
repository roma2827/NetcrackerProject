import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {FilmService} from '../services/film.service';
import {FilmComponent} from '../modules/film/film.component';
import {FilmDetailComponent} from './film-detail/film.detail.component';
import {HomeComponent} from '../modules/home/home.component'
import {SessionService} from '../services/session.service'
import {HallComponent} from "./hall/hall.component";
import {HallService} from "../services/hall.service";
import {PlaceService} from "../services/place.service";
import {TicketService} from "../services/ticket.service";


@NgModule({
  declarations: [
    HallComponent,
    FilmComponent,
    FilmDetailComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),

  ],

  providers: [FilmService, SessionService, HallService, PlaceService, TicketService],
  exports: [FilmComponent, FilmDetailComponent, HomeComponent, HallComponent]
})
export class FilmModule {
}
