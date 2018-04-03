import {EventEmitter, Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";
import {Observable} from "rxjs/Observable";
import {Projet} from "../models/projet";
import {Categorie} from "../models/categorie";

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

  public getCategories(): Observable<Categorie[]> {
    return this.http.get<Categorie[]>('/api/categories');
  }

  public createProjet(projet: Projet): Observable<Projet> {
    return this.http.post<Projet>('/api/user/projet/', projet);
  }
}
