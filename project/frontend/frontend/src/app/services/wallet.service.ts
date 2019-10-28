import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Wallet } from "../modules/models/wallet";



@Injectable()
// Data service
export class WalletService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getWallets(): Observable<Wallet[]> {
    return this.http.get<Wallet[]>('/api/wallet')
  }

  saveWallet(wallet: Wallet): Observable<Wallet> {
    return this.http.post<Wallet>('/api/wallet', wallet);
  }

  // deleteWallet(idWallet: number): Observable<void> {
  //   return this.http.delete<void>('/api/wallet/' + idWallet);
  // }
  
}