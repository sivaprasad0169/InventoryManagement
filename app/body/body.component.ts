import {Component} from "@angular/core";
import {LoginService} from "../services/login-service";
import {Router} from "@angular/router"
import {FormGroup} from "@angular/forms";

@Component({
  selector:'load-component',
  templateUrl:'./body.component.html',
  styleUrls:['./body.component.css']
})

export class BodyComponent{
  title='Hello';
  /*postedData:string;
  postError:string;
  constructor(private  _user:LoginService,private router:Router){}
  on(value){
    console.log(value);
  }
  onSubmit(value){
    console.log(value);
  }
  ValidateData(uname,pwd){

    console.log("Working"+uname+pwd);
   /!*this._user.ValidateUserData(uname,pwd)
      .subscribe(resEmployeeData=>this.postedData=JSON.stringify(resEmployeeData),
        resEmployeeError=>this.postError=resEmployeeError);*!/

      this._user.ValidateUserData(uname,pwd)
        .subscribe(data => {
            if ( data.isValid === true) {
              this.router.navigate(['/home']);
            }
          },
          dataError => this.postError = dataError);


  }*/
}
