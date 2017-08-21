import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {HttpModule} from "@angular/http";
import {TestComponent} from "./login.component";



@NgModule({
  declarations: [
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: []
})
export class LoginModule { }
