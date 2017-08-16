import {Component,OnInit} from "@angular/core";
import { UpdateService} from "./UpdateService"
import {ActivatedRoute,Router} from "@angular/router";
import {Params} from "@angular/router"
import {promise} from "selenium-webdriver";
import consume = promise.consume;
import {isNumber} from "util";
import {DataService} from "../services/data.service";

@Component({
  selector:'employee-details',
  templateUrl:'./update-item.component.html',
  styleUrls:['./update-item.component.css']
})

export class UpdateItemComponent implements OnInit{

  public itemId;
  errorMsg:string;
  public item;
  updateError:string;

  loggedUser:string="Admin";

  result:number;
  consumed:number=0;
  purchased:number=0;

  constructor(private  dataService:DataService,private updateService:UpdateService,private route:ActivatedRoute,private router:Router){}

  ngOnInit(){

    let id=this.route.snapshot.params['id'];
    this.itemId=id;


    this.dataService.loggedUserUpdated.subscribe(
      (loggedUser) => {
        this.loggedUser = this.dataService.getLoggedUserName();
      }
    );

    this.updateService.getItemById(id)
      .subscribe(itemsData=>this.item=itemsData,
        errorMessage=>this.errorMsg=errorMessage);

  }


  OnKeyPress(available,consumed,produced){

    this.result =parseInt(available)+parseInt(produced)-parseInt(consumed);
    if(this.result<0)
    {
      alert("Hey.You cant Consume more than you Have..!");
      this.result=0;
      this.consumed=0;
      this.purchased=0;
    }
  }



  onSaveClick(ItemId,NewName,purchase,consumed,updated){
      updated=parseInt(this.item.availableQuantity)+parseInt(purchase)-parseInt(consumed);

      if(updated>=0) {
        this.updateService.updateItemDetails(ItemId, NewName, purchase, consumed, updated,this.loggedUser)
          .subscribe(data => {
              if (data !== 0) {
                this.router.navigate(['/update']);
                alert("Item Updated SuccessFully ");
                // this.pageReload();

              }
              else {
                this.errorMsg = "Unable to Delete !";
              }
            },
            dataError => this.updateError = dataError);
      }
      else
      {
        this.router.navigate(['/update']);
        alert("Item cant be updated ");
      }
  }
}
