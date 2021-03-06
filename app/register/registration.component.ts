import {Component, OnInit} from "@angular/core";
import {DataService} from "../services/data.service";
import {LoginService} from "../services/login-service";
import {RegisterService} from "../services/register.service";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Validators} from "@angular/forms";





@Component({
  selector:'reg-component',
  templateUrl:'./registration.component.html',
  styleUrls: ['./registration.component.css']

})

export class RegistrationComponent implements OnInit{

  public errorMsg:string;
  public postError:string;

  registerForm:FormGroup;
  password;
  confirmPassword;

  isUserNameExisted:boolean;

  formNotValidFlag=false;
  formNotValidMessage:string;

  constructor(private  _formBuilder:FormBuilder,private  dataService:DataService,private registerService:RegisterService,private router:Router){}


  ngOnInit()
  {

    this.registerForm=this._formBuilder.group({
      firstName:['',[Validators.required]],
      userName:['',[Validators.required,Validators.minLength(5)]],
      confirmPassword: ['', Validators.compose([
        Validators.required,

      ])],
      password: ['', Validators.compose([
        Validators.required,

      ])]


    })

  }


  onSumbitForm(uname,pwd,fname,lname,email){
    console.log(this.dataService.loggedUser);

    if(this.registerForm.valid) {

      this.registerService.postUserRegistrationData(uname, pwd, fname, lname, email)
        .subscribe(data => {
            if (data !== 0) {
              this.router.navigate(['/login']);
              alert("You have Successfullt Registered ");

            }
            else {
              this.errorMsg = "Unable Register Your Details !";
            }
          },
          dataError => this.postError = dataError);
    }
    else{
      this.formNotValidFlag=true;
      this.formNotValidMessage="All * fields should be filled";

    }




  }
  checkPasswordMatching()
  {
    if(this.password!=this.confirmPassword)
    {
      this.confirmPassword='';
    }
  }

  checkAvailability(userName)
  {
    console.log("entered",userName);
    if(userName.length>5) {
      this.registerService.checkUserNameAvailability(userName)
        .subscribe(data => {
            if (data === true) {
              console.log(data);
              this.isUserNameExisted = data;

            }
            else {
              this.isUserNameExisted = false;
            }
          },
          dataError => this.postError = dataError);
    }

  }


}

