import {EventEmitter, Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";
import {Observable} from "rxjs/Observable";
import {Projet} from "../models/projet";
import {Categorie} from "../models/categorie";
import {TypeContribution} from "../models/type-contribution";
import {environment} from "../../environments/environment";

@Injectable()
export class AdminService {

  constructor(private http: HttpClient) {
  }

  public getProjetsVisibles(): Observable<Projet[]> {
    return this.http.get<Projet[]>(environment.api_url + '/api/projetsVisibles');
  }

  public getProjet(id: number): Observable<Projet> {
    return this.http.get<Projet>(environment.api_url + '/api/projet/' + id);
  }

  public getCategories(): Observable<Categorie[]> {
    return this.http.get<Categorie[]>(environment.api_url + '/api/categories');
  }

  public createProjet(projet: Projet): Observable<Projet> {
    return this.http.post<Projet>(environment.api_url + '/api/user/projet', projet);
  }

  public createTypeContribution(typeContribution: TypeContribution): Observable<TypeContribution> {
    return this.http.post<TypeContribution>(environment.api_url + '/api/user/typeContribution', typeContribution);
  }
}
