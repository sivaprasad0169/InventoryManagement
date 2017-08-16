import {Component, Input, OnChanges, OnInit, SimpleChanges} from "@angular/core";
import {DataService} from "../services/data.service";
import {CategoryService} from "../services/category.service";
import {LoginService} from "../services/login-service";

@Component({
  selector:'head-component',
  templateUrl:'./head.component.html',
  styleUrls:['./head.component.css'],
  inputs:['loggedUser'],

})

export class HeadComponent implements OnInit{

  title1='Inventory';
  title2='Management';

  isLoggedIn:boolean=false;
  loggedUser:string;

  isLoggedOut:boolean;
  errorMsg:string;



  constructor(private _dataService:DataService,private  loginService:LoginService) {
  }

  ngOnInit()
  {

    this.loggedUser=localStorage.getItem("user");

    this.loginService.checkForSession()
      .subscribe(data => this.isLoggedIn = data,
        Error => this.errorMsg = Error);


    this._dataService.loggedUserUpdated.subscribe(
      (loggedUser) => {
        this.loggedUser = this._dataService.getLoggedUserName();
      }
    );

    this._dataService.isLoggedInUpdated.subscribe(
      (isLoggedIn) => {
        this.isLoggedIn = this._dataService.getIsLogStatus();
      }
    );


  }

  onLogOutClick()
  {
    if(confirm("Are You Sure !"))
    {

      this.loginService.removeSession().subscribe(data => this.isLoggedOut = data,
        Error => this.errorMsg = Error);

      if (!this.isLoggedOut)
      {
        this.isLoggedIn = this.isLoggedOut;
      }
    }

  }




}
