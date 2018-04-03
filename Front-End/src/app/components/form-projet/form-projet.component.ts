import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {AdminService} from "../../services/admin.service";
import {Categorie} from "../../models/categorie";
import {Router} from "@angular/router";
import {User} from "../../models/user";
import {AuthService} from "../../services/auth.service";
import {Projet} from "../../models/projet";

@Component({
  selector: 'app-form-projet',
  templateUrl: './form-projet.component.html',
  styleUrls: ['./form-projet.component.css']
})
export class FormProjetComponent implements OnInit {

  contributions: string[];
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
    if (!this.contributions) {
      this.contributions = [];
    }
    this.contributions.push(contribution.value);
    contribution.value = '';
  }

  public onSubmit(projetForm: NgForm): void {
    if (projetForm.valid) {
      let projet: Projet = projetForm.value;
      // projet.entrepreneuse = this.user.username; -> TODO à faire en back-end
      projet.contributions = this.contributions;
      // console.log(projetForm.value.nom);
      this.adminService.createProjet(projetForm.value).subscribe(
        projet => this.router.navigate(['']),
        err => {
          this.errorMessage = "Erreur de connexion avec le serveur"
        }
      );
    } else {
      console.log(projetForm.errors);
      this.errorMessage = "Le formulaire n'est pas valide. Veuillez corriger les champs indiqués."
    }
  }
}
