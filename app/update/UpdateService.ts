import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Headers} from "@angular/http"
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()

export class UpdateService{
  private  _url:string="http://192.168.35.68:8080/inventory/InventoryItems/get";
  private _urlDelete:string="http://192.168.35.68:8080/inventory/InventoryItems/delete";
  private _urlUpdate:string="http://192.168.35.68:8080/inventory/InventoryItems/update";
  private _urlPost:string="http://192.168.35.68:8080/inventory/InventoryItems/post";
  private _urlItemById:string="http://192.168.35.68:8080/inventory/InventoryItem/GetItemDetailsById";
  private  _urlcheckAvailability:string="http://192.168.35.68:8080/inventory/checkItemName";
  constructor(private _http:Http){}

  getAllItems()
  {

   return this._http.get(this._url).map((response:Response)=>response.json())
      .catch(this._catchError);

  }
  _catchError(error:Response){
    return Observable.throw(error || 'server Error');
  }


  getItemById(itemId)
  {
    let data=itemId;
    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlItemById,data)
      .map((res:Response)=>res.json());
  }


  removeSelectedRecord(itemId)
  {
    let data={"itemId":itemId}
    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlDelete,data)
      .map((res:Response)=>res.json());



  }



  updateItemDetails(itemId,itemName,purchasedQuantity,consumedQuantity,availableQuantity,loggedUser)
  {
    let data=[{
      "itemId":itemId,
      "updatedItemName":itemName,
      "purchasedQuantity":purchasedQuantity,
      "consumedQuantity":consumedQuantity,
      "itemUpdatedQuantity":availableQuantity,
      "updatedBy":localStorage.getItem("user")
    }]
    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.put(this._urlUpdate,data)
      .map((res:Response)=>res.json());
  }



  addNewItem(itemName,quantity,selected,loggedUser)
  {
    let data=[{
      "itemName":itemName,
      "itemQuantity":quantity,
      "updatedBy":localStorage.getItem("user"),
      "categoryId":selected
    }]
    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlPost,data)
      .map((res:Response)=>res.json());


  }
  checkItemNameAvailability(itemName)
  {

    let postData=itemName;
    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlcheckAvailability,postData)
      .map((res:Response)=>res.json());

  }


}
