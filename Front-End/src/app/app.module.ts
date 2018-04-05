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
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ShowProjetComponent } from './components/show-projet/show-projet.component';
import { FormProjetComponent } from './components/form-projet/form-projet.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';
import { ContributionComponent } from './components/contribution/contribution.component';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'projet/create',
    component: FormProjetComponent
  },
  {
    path: 'projet/:id',
    component: ShowProjetComponent
  },
  {
    path: 'projet/contribute/:id',
    component: ContributionComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    ShowProjetComponent,
    FormProjetComponent,
    SideBarComponent,
    ContributionComponent
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
