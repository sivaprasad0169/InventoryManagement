import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Headers} from "@angular/http"
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()

export class CategoryService{


  public  _urlGetCategories:string="http://192.168.35.68:8080/inventory/Categories/get";
  public  _urlGetCategoryId:string="http://192.168.35.68:8080/inventory/Categories/getCategoryId";
  public _urlAddCategory:string="http://192.168.35.68:8080/inventory/Categories/addCategory";
  constructor(private _http: Http) {
  }


  getAllCategories()
  {


    return this._http.get(this._urlGetCategories).map((response: Response) => response.json())
      .catch(this._catchError);

  }
  _catchError(error: Response)
  {
    return Observable.throw(error || 'server Error');
  }

  addCategory(categoryName)
  {

    let postData=categoryName;
    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlAddCategory,postData)
      .map((res:Response)=>res.json());

  }




}

