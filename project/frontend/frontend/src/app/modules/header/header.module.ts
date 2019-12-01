import { NgModule } from "@angular/core";
import {HeaderComponent} from "./components/header.component";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {BrowserModule} from "@angular/platform-browser";
import {StorageService} from "../../services/storage.service";


@NgModule({
  declarations: [
    HeaderComponent
  ],
  imports: [
    RouterModule,
    FormsModule,
    BrowserModule
  ],
  providers: [UserService, StorageService],
  exports: [HeaderComponent]
})
export class HeaderModule {}
