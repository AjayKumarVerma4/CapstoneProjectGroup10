import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cart } from '../model/cart';
import { CartDTO } from '../model/cartDTO';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartDTOItemArray:Array<CartDTO>=[];

id:string="";

totalqty: number = 0;
totalPrice: number=0;

userId:any=sessionStorage.getItem("userId");

  constructor(private route: ActivatedRoute, private service:CartService) {

   }

  ngOnInit(): void {
    this.service.getCartItemListByUserId(this.userId).subscribe((data)=>{
      this.cartDTOItemArray=data;

      for (let item of this.cartDTOItemArray) {
        this.totalPrice = this.totalPrice + item.foodPrice;
      }
      this.totalqty = this.cartDTOItemArray.length;
      
    localStorage.setItem('total_price', JSON.stringify(this.totalPrice));
    localStorage.setItem('total_quantity', JSON.stringify(this.totalqty));

    })
  }

}
