import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public errorMessage: string;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.authService.connectedUser.subscribe(
      user => {
        if (user != null) {
          this.router.navigate([''])
        } else {
          this.errorMessage = "Une erreur interne s'est produite, veuillez ré-essayer plus tard."
        }
      }
    )
  }

  public onSubmit(loginForm: NgForm): void {
    if (loginForm.valid) {
      this.authService.login(loginForm.value);
    }
  }
}
