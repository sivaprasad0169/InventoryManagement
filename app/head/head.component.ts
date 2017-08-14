import {Component, Input, OnChanges, OnInit, SimpleChanges} from "@angular/core";
import {DataService} from "../services/data.service";
import {CategoryService} from "../services/category.service";

@Component({
  selector:'head-component',
  templateUrl:'./head.component.html',
  styleUrls:['./head.component.css'],
  inputs:['loggedUser']

})

export class HeadComponent implements OnInit{

  title1='Inventory';
  title2='Management';

  isLoggedIn:boolean=false;
  loggedUser:string;



  constructor(private _dataService:DataService) {
  }

  ngOnInit()
  {

    this._dataService.langUpdated.subscribe(
      (loggedUser) => {
        this.loggedUser = this._dataService.getLang();
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
    this.isLoggedIn=false;

  }




}
