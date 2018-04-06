import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {AdminService} from "../../services/admin.service";
import {Categorie} from "../../models/categorie";
import {Router} from "@angular/router";
import {User} from "../../models/user";
import {AuthService} from "../../services/auth.service";
import {Projet} from "../../models/projet";
import {forEach} from "@angular/router/src/utils/collection";
import {TypeContribution} from "../../models/type-contribution";

@Component({
  selector: 'app-form-projet',
  templateUrl: './form-projet.component.html',
  styleUrls: ['./form-projet.component.css']
})
export class FormProjetComponent implements OnInit {

  typesContributions: string[];
  categories: Categorie[];
  errorMessage: string;
  user: User;

  constructor(private authService: AuthService, private adminService: AdminService, private router: Router) { }

  ngOnInit() {
    this.authService.connectedUser.subscribe(
      user => this.user = user,
      err => this.user = null
    );
    this.adminService.getCategories().subscribe(
      categories => this.categories = categories,
      err => {
        this.categories = null;
        this.errorMessage = "Erreur de connexion avec le serveur"
      }
    );
  }

  public ajoutContribution(contribution: HTMLInputElement): void {
    if (!this.typesContributions) {
      this.typesContributions = [];
    }
    this.typesContributions.push(contribution.value);
    contribution.value = '';
  }

  public onSubmit(projetForm: NgForm): void {
    if (projetForm.valid) {
      let projet: Projet = projetForm.value;
      // projet.entrepreneuse = this.user.username; -> TODO à faire en back-end
      // console.log(projetForm.value.nom);
      this.adminService.createProjet(projet).subscribe(
        proj => {
          projet.id = proj.id;
          for (let type of this.typesContributions) {
            let typeContribution: TypeContribution = new TypeContribution(0, type, projet.id);
            this.adminService.createTypeContribution(typeContribution).subscribe(
              typeContrib => { },
              err => { this.errorMessage = "Erreur de connexion avec le serveur" }
            )
          }
        },
        err => {
          this.errorMessage = "Erreur de connexion avec le serveur"
        }
        )
        this.router.navigate([''])
    } else {
      console.log(projetForm.errors);
      this.errorMessage = "Le formulaire n'est pas valide. Veuillez corriger les champs indiqués."
    }
  }
}
