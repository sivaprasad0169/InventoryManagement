import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import {FooterComponent} from "./footer.component";


@NgModule({
  declarations: [FooterComponent],
  imports: [CommonModule],
  providers: [],
  bootstrap: [],
  exports: [FooterComponent]
})
export class FooterModule { }
