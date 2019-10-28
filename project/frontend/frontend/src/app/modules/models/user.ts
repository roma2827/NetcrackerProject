import { Wallet } from "./wallet";

export class User {
  idUser: number;
  role: string;
  login: string;
  password: string;
  wallet: Wallet
}