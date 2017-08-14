import {Component} from "@angular/core";
import {LoginService} from "../services/login-service";
import {Router} from "@angular/router"
import {FormGroup} from "@angular/forms";
import {DataService} from "../services/data.service";

@Component({
  templateUrl:'./test.component.html',
  styleUrls:['./test.component.css']
})

export class TestComponent{
  title='Hello';
  postError:string;
  loggedUser:string;
  error:string;
  constructor(private  _user:LoginService,private router:Router,private dataService:DataService){}
  on(value){
    console.log(value);
  }
  onSubmit(value){
    console.log(value);
  }



  ValidateData(uname,pwd){


      this._user.ValidateUserData(uname,pwd)
        .subscribe(data => {
            if ( data.isValid === true)
            {
              this.dataService.setLang(data.userFullName);
              this.dataService.setIsLogStatus(true);
              this.loggedUser=data.userFullName;
              this.router.navigate(['/home']);
              alert("Hello "+this.loggedUser+", You have Successfullt logged In");

            }
            else
            {
              this.error="Invalid Details";
            }
          },
          dataError => this.postError = dataError);



  }
}
