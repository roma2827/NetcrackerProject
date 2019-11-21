import { Wallet } from "./wallet";
import {Ticket} from "./ticket";

export class User {
  idUser: number;
  role: string;
  login: string;
  password: string;
  wallet: Wallet;
  ticket: Ticket;

}
