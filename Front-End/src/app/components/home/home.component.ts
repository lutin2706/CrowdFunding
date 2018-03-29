import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {User} from "../../models/user";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user: User;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.connectedUser.subscribe(
      user => {
        this.user = user;
       },
      err => this.user = null
    );
  }

}
