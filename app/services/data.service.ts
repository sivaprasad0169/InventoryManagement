import {EventEmitter, Injectable, OnChanges, Output} from "@angular/core";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from "rxjs/Observable";
import {Observer} from "rxjs/Observer";

@Injectable()

export class DataService{
   public loggedUser:string;
   public isLoggeIn:boolean;

  langUpdated:EventEmitter<string> = new EventEmitter<string>();
  isLoggedInUpdated:EventEmitter<boolean> = new EventEmitter<boolean>();

  setLang(lang) {
    this.loggedUser = lang;
    this.langUpdated.emit(this.loggedUser);
  }
  setIsLogStatus(value:boolean)
  {
    this.isLoggeIn=value;
    this.isLoggedInUpdated.emit(this.isLoggeIn);

  }

  getIsLogStatus()
  {
    return this.isLoggeIn;
  }

  getLang() {
    return this.loggedUser;
  }



/*
  isLoggedIn: Observable<boolean>;
  observer: Observer<boolean>;

  constructor() {
    this.isLoggedIn = new Observable(observer =>
      this.observer = observer
    )//.share();
  }*/

}

