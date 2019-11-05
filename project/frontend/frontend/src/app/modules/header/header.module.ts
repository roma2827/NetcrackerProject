import { NgModule } from "@angular/core";
import {HeaderComponent} from "./components/header.component";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {UserService} from "../../services/user.service";


@NgModule({
  declarations: [
    HeaderComponent,
  ],
  imports: [
    RouterModule,
    FormsModule
  ],
  providers: [UserService],
  exports: [HeaderComponent]
})
export class HeaderModule {}
