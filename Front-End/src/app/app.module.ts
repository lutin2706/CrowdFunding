import { BrowserModule } from '@angular/platform-browser';
import {NgModule, OnInit} from '@angular/core';


import { AppComponent } from './components/app.component';
import { LoginComponent } from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {Route, RouterModule} from "@angular/router";
import {AuthService} from "./services/auth.service";
import {AuthInterceptor} from "./services/auth.interceptor";
import {AdminService} from "./services/admin.service";
import { HomeComponent } from './components/home/home.component';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    AuthService,
    AdminService,
    // Pour que l'intercepteur fasse son boulot:
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
