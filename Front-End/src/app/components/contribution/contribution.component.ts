import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../services/admin.service";
import {ActivatedRoute} from "@angular/router";
import {Projet} from "../../models/projet";
import {TypeContribution} from "../../models/type-contribution";

@Component({
  selector: 'app-contribution',
  templateUrl: './contribution.component.html',
  styleUrls: ['./contribution.component.css']
})
export class ContributionComponent implements OnInit {

  id: number;
  errorMessage: string;
  projet: Projet;
  typesContributions: TypeContribution[];

  constructor(private maRoute: ActivatedRoute, private adminService: AdminService) { }

  ngOnInit() {
    this.maRoute.params.subscribe(
      params => {
        this.id = params['id'];
        this.adminService.getProjet(this.id).subscribe(
          projet => {
            this.projet = projet;
            this.adminService.getTypesContributions(projet.id).subscribe(
              types => this.typesContributions = types,
              err => this.errorMessage = "Une erreur interne est survenue. Veuillez essayer plus tard"
            );
          },
              err => this.errorMessage = "Une erreur interne est survenue. Veuillez essayer plus tard"
        )
      }
    )
  }

}
