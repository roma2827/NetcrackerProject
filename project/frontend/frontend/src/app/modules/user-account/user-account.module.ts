import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {TicketService} from "../../services/ticket.service";
import {UserService} from "../../services/user.service";
import {UserAccountComponent} from "./user-account.component";
import {WalletService} from "../../services/wallet.service";
import {StorageService} from "../../services/storage.service";

@NgModule({
  declarations: [
    UserAccountComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
  ],

  providers: [UserService, TicketService, WalletService, StorageService],
  exports: [UserAccountComponent]
})
export class UserAccountModule {
}
