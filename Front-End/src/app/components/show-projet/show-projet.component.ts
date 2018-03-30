import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdminService} from "../../services/admin.service";
import {Projet} from "../../models/projet";

@Component({
  selector: 'app-show-projet',
  templateUrl: './show-projet.component.html',
  styleUrls: ['./show-projet.component.css']
})
export class ShowProjetComponent implements OnInit {

  id: number;
  errorMessage: string;
  projet: Projet;

  constructor(private maRoute: ActivatedRoute, private adminService: AdminService) { }

  ngOnInit() {
    this.maRoute.params.subscribe(
      params => {
        this.id = params['id'];
        this.adminService.getProjet(this.id).subscribe(
          projet => this.projet = projet,
          err => this.errorMessage = "Une erreur interne est survenue. Veuillez essayer plus tard"
        )
      }
    )
  }

}
