import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from "ngx-bootstrap/modal";
import { FormsModule } from "@angular/forms";
import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {FilmModule} from './modules/film.module'
import {RouterModule, Routes} from "@angular/router";
import {FilmComponent} from './modules/film/film.component'
import {HeaderModule} from './modules/header/header.module'
import {FilmDetailComponent} from './modules/film-detail/film.detail.component'
import {HomeComponent} from './modules/home/home.component'

const appRoutes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'films', component: FilmComponent },
  { path: 'detail/:filmId', component: FilmDetailComponent}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    HeaderModule,
    FilmModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
