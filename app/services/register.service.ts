import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {post} from "selenium-webdriver/http";

@Injectable()

export class RegisterService{


  private  _urlRegDetailsPost:string="http://192.168.35.68:8080/inventory/LoginDetails/PostRegDetails";
  private  _urlcheckAvailability:string="http://192.168.35.68:8080/inventory/CheckUserName";

  constructor(private _http:Http){}


  postUserRegistrationData(uname,pwd,fname,lname,email)
  {
    console.log("Posting method");

    let postData=[{"userName":uname,"password":pwd,"firstName":fname,"lastName":lname,"emailId":email}]
    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlRegDetailsPost,postData)
      .map((res:Response)=>res.json());



  }

  checkUserNameAvailability(userName)
  {

    let postData=userName;
    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlcheckAvailability,postData)
      .map((res:Response)=>res.json());

  }



}

