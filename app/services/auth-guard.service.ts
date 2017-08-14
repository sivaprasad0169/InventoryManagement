import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {LoginService} from "./login-service";


@Injectable()
export class AuthGuardService implements CanActivate {
  private errorMsg;
  private flag;
  constructor(private loginService: LoginService, private route: Router) {}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    this.loginService.checkForSession()
      .subscribe(data => this.flag = data,
        dataError => this.errorMsg = dataError);

    if (this.flag === true)
    {
      console.log(this.flag);
    }

    else if (this.flag === false) {
      console.log('this is from authguard : ' + this.flag);
      this.route.navigate(['/login']);
    }
    return this.flag;
  }
}
