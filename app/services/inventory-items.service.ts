import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Headers} from "@angular/http"
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()

export class InventoryItemsService {

  private _urlget: string = "http://localhost:8080/inventory/InventoryItems/get";
  private _urlgetBysort:string="http://localhost:8080/inventory/InventoryItems/getItemsBySortingAndSearching";
  private _urlgetDetails:string="http://localhost:8080/inventory/InventoryItem/GetItemDetails";
  private _urlgetPurchaseDetails:string="http://localhost:8080/inventory/InventoryItem/GetItemPurchaseDetails";
  private _urlgetConsumeDetails:string="http://localhost:8080/inventory/InventoryItem/GetItemConsumeDetails";
  constructor(private _http: Http) {
  }


  getAllInventoryItems()
  {


    return this._http.get(this._urlget).map((response: Response) => response.json())
      .catch(this._catchError);

  }

  _catchError(error: Response)
  {
    return Observable.throw(error || 'server Error');
  }

  getInventoryItemsBySort(text,sortBy,category){

    let postData={"searchText":text,"sortBy":sortBy,"categoryId":category}

    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlgetBysort,postData)
      .map((res:Response)=>res.json());

  }


  getInventoryItemDetailsById(itemId)
  {
    let postData=itemId;

    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlgetDetails,postData)
      .map((res:Response)=>res.json());

  }


  getInventoryItemPurchaseDetailsById(itemId)
  {
    let postData=itemId;

    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlgetPurchaseDetails,postData)
      .map((res:Response)=>res.json());

  }


  getInventoryItemConsumeDetailsById(itemId)
  {
    let postData=itemId;

    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlgetConsumeDetails,postData)
      .map((res:Response)=>res.json());

  }
}
