import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";
import {environment} from "../../environments/environment";

@Injectable()
export class AuthService {

  // C'est ici qu'on va stocker les infos de session, afin d'avertir tous les autres modules d'un éventuel changement d'identité du user
  constructor(private http: HttpClient) { }

  public connectedUser: EventEmitter<User> = new EventEmitter<User>();

  public login(user: User): void {
    this.http.post(environment.api_url + '/api/login', user, {observe: 'response'}).subscribe(
      res => {

        let token = res.headers.get('Authorization').substr(7);
        localStorage.setItem('token', token); // On peut l'appeler autrement pour brouiller les pistes
        this.whoAmI();
      },
      err => {
        this.connectedUser.emit(null);  // On émet un nouvel événement pour dire que le user est null
      }
    );
  }

  public whoAmI(): void {
    // Un intercepteur va ajouter un header à toutes les requêtes qui sortent (et pourrait faire bien d'autres choses)
    // Voir services/auth.interceptor.ts

    if (localStorage.getItem('token') != null) {
      this.http.get<User>(environment.api_url + '/api/user/whoami').subscribe(
        user => this.connectedUser.emit(user),
        err => this.connectedUser.emit(null)
      );
    } else {
      this.connectedUser.emit(null);
    }
  }

  public logout(): void {
    localStorage.removeItem('token');
    this.connectedUser.emit(null);
  }
}
