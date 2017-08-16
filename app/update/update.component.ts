import {Component,OnInit} from "@angular/core";
import { UpdateService} from "./UpdateService"
import {Router} from "@angular/router";
import {InventoryItemsService} from "../services/inventory-items.service";

import {Validators} from "@angular/forms";
import {FormGroup,FormBuilder} from "@angular/forms";
import {CategoryService} from "../services/category.service";
import {DataService} from "../services/data.service";

@Component({
  templateUrl:'./update.component.html',
  styleUrls:['../details/details.component.css']
})

export class UpdateComponent implements OnInit{

  loggedUser:string="Admin";

  userForm:FormGroup;
  categoryForm:FormGroup;

  addItemError:string;
  addCategoryError:string;

  public items=[];
  public error:string;
  public postError:string;

  addItemFlag:boolean=false;
  availableitemsFlag:boolean=true;


  addCategoryFlag=false;
  selectCategoryFlag=true;

  categories=[];
  categoryError:string;

  constructor(private  dataService:DataService,private _formBuilder:FormBuilder,private updateService:UpdateService,private router:Router,private inventoryItems:InventoryItemsService,private  _categoryService:CategoryService){}

  ngOnInit(){

    this.updateService.getAllItems()
      .subscribe(resEmployeeData=>this.items=resEmployeeData,
        resEmployeeError=>this.addItemError=resEmployeeError);


    this._categoryService.getAllCategories()
      .subscribe(responseData=>this.categories=responseData,
        resError=>this.categoryError=resError);

    this.dataService.loggedUserUpdated.subscribe(
      (loggedUser) => {
        this.loggedUser = this.dataService.getLoggedUserName();
      }
    );


    this.userForm=this._formBuilder.group({
      itemName:['New Item',[Validators.required]],
      quantity:['0',[Validators.required]]


    })

    this.categoryForm=this._formBuilder.group({
      categoryName:['New Category',[Validators.required]]


    })
  }


  onEditClick(item)
  {
    this.router.navigate(['update',item.itemId]);
  }

  onAddItemClick()
  {
    this.addItemFlag=true;
    this.availableitemsFlag=false;
  }
  onCancelItem()
  {
    this.addItemFlag=false;
    this.availableitemsFlag=true;
  }
  AddItemDetails(name,quantity,selected)
  {

      console.log(name, quantity,selected);
      this.updateService.addNewItem(name, quantity,selected,this.loggedUser)
        .subscribe(data => {
            if (data !== 0) {
              alert("Item posted SuccessFully ");
              this.onCancelItem();
              this.pageReload();

            }
            else {
              this.addItemError = "Unable to Post !";
            }
          },
          dataError => this.postError = dataError);





  }



  onRemoveClick(item)
  {
  if(confirm("Are You Sure")) {
    this.updateService.removeSelectedRecord(item.itemId)
      .subscribe(data => {
          if (data !== 0) {
            this.router.navigate(['/update']);
           // alert("Item Deleted SuccessFully ");
            this.pageReload();

          }
          else {
            this.addItemError = "Unable to Delete !";
          }
        },
        dataError => this.postError = dataError);
  }

  }



  SeachText(value1,value2,category)
  {
    console.log(value1,value2,category);
    this.inventoryItems.getInventoryItemsBySort(value1,value2,category)
      .subscribe(resEmployeeData=>this.items=resEmployeeData,
        resEmployeeError=>this.addItemError=resEmployeeError);
  }

  pageReload()
  {
    this.updateService.getAllItems()
      .subscribe(resEmployeeData=>this.items=resEmployeeData,
        resEmployeeError=>this.addItemError=resEmployeeError);
  }

  onselect(value,value2,value3)
  {
    console.log(value,value2,value3);
  }


  changeAddCategoryFlag()
  {
    this.addCategoryFlag=!this.addCategoryFlag;
    this.selectCategoryFlag=!this.selectCategoryFlag;
  }

  addCategory(categoryName)
  {

    this._categoryService.addCategory(categoryName)
      .subscribe(responseData=>this.categories=responseData,
        resError=>this.addCategoryError=resError);

    this.changeAddCategoryFlag();

  }







}
