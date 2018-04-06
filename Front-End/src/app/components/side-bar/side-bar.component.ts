import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../services/admin.service";
import {ActivatedRoute} from "@angular/router";
import {Projet} from "../../models/projet";

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {

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
