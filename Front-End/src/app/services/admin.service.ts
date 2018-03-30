import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";
import {Observable} from "rxjs/Observable";
import {Projet} from "../models/projet";

@Injectable()
export class AdminService {

  constructor(private http: HttpClient) {
  }

  public getProjetsVisibles(): Observable<Projet[]> {
    return this.http.get<Projet[]>('/api/projetsVisibles');
  }

  public getProjet(id: number): Observable<Projet> {
    return this.http.get<Projet>('/api/projet/' + id);
  }
}
