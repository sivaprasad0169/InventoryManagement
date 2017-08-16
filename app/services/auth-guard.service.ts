import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {LoginService} from "./login-service";


@Injectable()
export class AuthGuardService implements CanActivate
{

  private errorMsg;
  private isUserLogged;

  constructor(private loginService: LoginService, private route: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  {

    return new Promise<boolean>((resolve, reject) =>this.loginService.checkForSession()
      .subscribe(data => {
          this.isUserLogged = data;
          if (this.isUserLogged === true)
          {
          }
          else if (this.isUserLogged === false) {
            this.route.navigate(['/login']);
          }
          resolve(true)
        }
        ,
        dataError => {
          this.errorMsg = dataError;
          resolve(false)
        }
      )
    )
  }
}
