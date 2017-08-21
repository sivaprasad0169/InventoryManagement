import {NgModule} from "@angular/core";
import {RouterModule,Routes} from "@angular/router";

import {UpdateComponent} from "./update/update.component";
import {DetailsComponent} from "./details/details.component";
import {RegistrationComponent} from "./register/registration.component";
import {TestComponent} from "./login/login.component";
import {AvailabeItemsComponent} from "./available/availabe-items.component";
import {HomeComponent} from "./home/home.component";
import {UpdateItemComponent} from "./update/update-item.component";
import {AuthGuardService} from "./services/auth-guard.service";

const routes:Routes=[
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path:'home',component:HomeComponent},
  {path:'update',canActivate:[AuthGuardService], component:UpdateComponent},
  {path:'available',component:AvailabeItemsComponent},
  {path:'details',component:DetailsComponent},
  {path:'login',component:TestComponent},
  {path:'register',component:RegistrationComponent},
  {path:'update/:id',canActivate:[AuthGuardService],component:UpdateItemComponent}

];
@NgModule({
  imports:[RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule{}
/*export const routingComponents=[TestComponent,RegistrationComponent,HomeComponent,UpdateComponent,AvailabeItemsComponent,DetailsComponent];*/
