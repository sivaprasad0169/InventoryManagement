import {Component,OnInit} from "@angular/core";
import {InventoryItemsService} from "../services/inventory-items.service";
import {CategoryService} from "../services/category.service";


@Component({
  templateUrl:'./details.component.html',
  styleUrls:['./details.component.css']
})
export class DetailsComponent implements OnInit{
  title='DetailsComponent';
  public itemsDetails=[];

  public itemName;
  public itemDetails=[];
  public itemPurchaseDetails=[];
  public itemConsumeDetails=[];

  categories=[];
  categoryError:string;


  getError:string=null;

  itemsDetailsFlag:boolean=true;
  itemDetailsFlag:boolean=false;


  constructor(private inventoryItems:InventoryItemsService,private  _categoryService:CategoryService){}

  ngOnInit()
  {
    this.inventoryItems.getAllInventoryItems()
      .subscribe(responseData=>this.itemsDetails=responseData,
        resError=>this.getError=resError);
    console.log(this.getError);


    this._categoryService.getAllCategories()
      .subscribe(responseData=>this.categories=responseData,
        resError=>this.categoryError=resError);


  }
  SeachText(value1,value2,category)
  {
  console.log(value1,value2,category);
    this.inventoryItems.getInventoryItemsBySort(value1,value2,category)
      .subscribe(resEmployeeData=>this.itemsDetails=resEmployeeData,
        resEmployeeError=>this.getError=resEmployeeError);
  }

  onDetailsClick(value:any)
  {
    this.itemName=value.itemName;
    this.itemsDetailsFlag=false;
    this.itemDetailsFlag=true;

    this.inventoryItems.getInventoryItemDetailsById(value.itemId)
      .subscribe(responseData=>this.itemDetails=responseData,
        resError=>this.getError=resError);

    this.inventoryItems.getInventoryItemPurchaseDetailsById(value.itemId)
      .subscribe(responseData=>this.itemPurchaseDetails=responseData,
        resError=>this.getError=resError);

    this.inventoryItems.getInventoryItemConsumeDetailsById(value.itemId)
      .subscribe(responseData=>this.itemConsumeDetails=responseData,
        resError=>this.getError=resError);

  }


  onBackClick()
  {
    this.itemsDetailsFlag=true;
    this.itemDetailsFlag=false;

  }

  onselect(value)
  {
    console.log(value);
  }

}
