import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HeadComponent} from "./head/head.component";
import {BodyComponent} from "./body/body.component";
import {RegistrationComponent} from "./register/registration.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {LoginService} from "./services/login-service";
import {HttpModule} from "@angular/http";
import {InventoryItemsService} from "./services/inventory-items.service";
import {LoginModule} from "./login/login.module";
import {RegisterModule} from "./register/register.module";
import {DetailsModule} from "./details/details.module";
import {UpdateModule} from "./update/update.module";
import {AvailableModule} from "./available/available.module";
import {FooterModule} from "./footer/footer.module";
import {HomeModule} from "./home/home.module";
import {TestComponent} from "./login/login.component";
import {RegisterService} from "./services/register.service";
import {UpdateService} from "./update/UpdateService";
import {DataService} from "./services/data.service";
import {AuthGuardService} from "./services/auth-guard.service";
import {CategoryService} from "./services/category.service";
import {CanActivate} from "@angular/router";
import {CapitalizePipe} from "./pipes/capitalize.pipe";

@NgModule({
  declarations: [
    AppComponent,
    HeadComponent,
    RegistrationComponent,
    TestComponent,
    BodyComponent,
    CapitalizePipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpModule,
    LoginModule,
    RegisterModule,
    DetailsModule,
    UpdateModule,
    AvailableModule,
    FooterModule,
    HomeModule
  ],
  providers:
    [
      LoginService,
      InventoryItemsService,
      RegisterService,
      UpdateService,
      DataService,
      AuthGuardService,
      CategoryService
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
