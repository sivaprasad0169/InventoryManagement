import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {post} from "selenium-webdriver/http";

@Injectable()

export class LoginService{

  private  _urlGet:string="";
  private  _urlRegDetailsPost:string="http://192.168.35.68:8080/inventory/LoginDetails/PostRegDetails";
  private  _urlValidate:string="http://192.168.35.68:8080/inventory/Validate";

  constructor(private _http:Http){}

  getUserData()
  {


    return this._http.get(this._urlGet).
    map((response:Response)=>response.json())
      .catch(this._catchError);

  }

  _catchError(error:Response)
  {

    return Observable.throw(error || 'server Error');
  }

  postUserRegistrationData(uname,pwd,fname,lname)
  {
    console.log("Posting method");

    let postData=[{"userName":uname,"password":pwd,"firstName":fname,"lastName":lname}]

    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlRegDetailsPost,postData,{headers,withCredentials:true})
      .map((res:Response)=>res.json());



  }

  ValidateUserData(uname,pwd){

    let postData={"userName":uname,"password":pwd,"firstName":"Unknown","lastName":null}

    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlValidate,postData,{withCredentials:true})
      .map((res:Response)=>res.json());

  }

  checkForSession() {
    const _urlCheckSession = 'http://192.168.35.68:8080/inventory/CheckSession';
    const headers = new Headers();
    headers.append('Content-Type',
      'text/plain');
    return this._http.get(_urlCheckSession, { headers: headers, withCredentials: true })
      .map((response: Response) => response.json())

  }

  removeSession()
  {

    const _urlremoveSession = 'http://192.168.35.68:8080/inventory/removeSession';
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.get(_urlremoveSession, { headers: headers, withCredentials: true })
      .map((response: Response) => response.json())


  }


}

