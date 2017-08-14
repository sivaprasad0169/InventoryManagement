import {Component,OnInit} from "@angular/core";
import {InventoryItemsService} from "../services/inventory-items.service";
import {CategoryService} from "../services/category.service";


@Component({
  templateUrl:'./available-items.component.html',
  styleUrls:['../details/details.component.css']
})
export class AvailabeItemsComponent implements OnInit{
  title='DetailsComponent';
  public itemsDetails=[];
  getError:string=null;

  categories=[];
  categoryError:string;

  constructor(private inventoryItems:InventoryItemsService,private  _categoryService:CategoryService){}

  ngOnInit(){
    this.inventoryItems.getAllInventoryItems()
      .subscribe(responseData=>this.itemsDetails=responseData,
        resError=>this.getError=resError);
    console.log(this.getError);

    this._categoryService.getAllCategories()
      .subscribe(responseData=>this.categories=responseData,
        resError=>this.categoryError=resError);


  }
  SeachText(value1,value2,category){
    console.log(value1,value2,category);
    console.log("Working");
    this.inventoryItems.getInventoryItemsBySort(value1,value2,category)
      .subscribe(resEmployeeData=>this.itemsDetails=resEmployeeData,
        resEmployeeError=>this.getError=resEmployeeError);
  }

  onselect(value)
  {
    console.log(value);
  }
}
