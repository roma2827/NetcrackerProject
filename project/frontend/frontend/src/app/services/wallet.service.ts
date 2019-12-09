import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Wallet } from "../modules/models/wallet";



@Injectable()
export class WalletService {

  constructor(private http: HttpClient) {
  }

  getWallets(): Observable<Wallet[]> {
    return this.http.get<Wallet[]>('/api/wallet')
  }

  saveWallet(wallet: Wallet): Observable<Wallet> {
    return this.http.post<Wallet>('/api/wallet', wallet);
  }

  replenishmentOfFund(idWallet: number, money: string): Observable<void> {
    return this.http.post<void>('/api/wallet/rep/' + idWallet, money);
  }

  // deleteWallet(idWallet: number): Observable<void> {
  //   return this.http.delete<void>('/api/wallet/' + idWallet);
  // }

}
