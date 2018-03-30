import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../services/admin.service";
import {Projet} from "../../models/projet";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  projets: Projet[];
  errorMessage: string;

  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.adminService.getProjetsVisibles().subscribe(
      projets => this.projets = projets,
      err => {
        this.projets = null;
        this.errorMessage = "Erreur de connexion avec le serveur"
      }
    );
  }
}
