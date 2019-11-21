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
import {HeaderComponent} from "./modules/header/components/header.component";
import {HallComponent} from "./modules/hall/hall.component";
import {UserAccountComponent} from "./modules/user-account/user-account.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import $ from "jquery";

const appRoutes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'films', component: FilmComponent },
  { path: 'detail/:filmId', component: FilmDetailComponent},
  { path: 'hall/:idSession', component: HallComponent},
  { path: 'user-account/:login', component: UserAccountComponent}
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
    RouterModule.forRoot(appRoutes),
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
