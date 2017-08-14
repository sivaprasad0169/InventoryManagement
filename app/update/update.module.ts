import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {HttpModule} from "@angular/http";
import {UpdateComponent} from "./update.component";
import {UpdateItemComponent} from "./update-item.component";




@NgModule({
  declarations: [
      UpdateComponent,UpdateItemComponent
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
export class UpdateModule { }
