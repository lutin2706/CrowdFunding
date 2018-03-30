import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public user: User;

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    this.authService.connectedUser.subscribe(
      user => this.user = user,
      err => this.user = null
    );
  }

  public logout(): void {
    this.authService.logout();
  }
}
