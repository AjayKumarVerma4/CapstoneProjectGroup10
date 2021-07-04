import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../model/restaurant';
import { CartService } from '../service/cart.service';
import { RestaurantService } from '../service/restaurant.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loginSuccess:string="";
  enableProp:number=0;

  restList:Array<Restaurant>=[];

  constructor(private service:RestaurantService, private cartService: CartService) { }

  ngOnInit(): void {
    this.service.getRestaurantList().subscribe((data)=>{
      this.restList=data;
    })
  }
  ngDoCheck(){ 
 
    // this.total_price=localStorage.getItem('total_price');
    // this.total_quantity=localStorage.getItem('total_quantity');
    // if(this.total_price > 0)
    // {
    //   this.btn_cart=true;
    // }
    //Here we Have put the login and signup button enable and disable
    this.loginSuccess  =this.cartService.getLoginSuccess();
    this.enableProp=this.cartService.getSuccessFlag();
   }
   
  
 onLogout(){
 //this.enableProp=1;
 location.reload();
 }

}
