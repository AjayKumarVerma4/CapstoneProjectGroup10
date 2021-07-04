import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cart } from '../model/cart';
import { Menu } from '../model/menu';
import { User } from '../model/user';
import { CartService } from '../service/cart.service';
import { MenuService } from '../service/menu.service';

@Component({
  selector: 'app-menu-by-restaurant',
  templateUrl: './menu-by-restaurant.component.html',
  styleUrls: ['./menu-by-restaurant.component.css']
})
export class MenuByRestaurantComponent implements OnInit {

  menuArrayByRestaurant:Array<Menu>=[];

  cart = new Cart();

  menu1 = new Menu();
  user1 = new User();

  id:string="";

  userId:any=sessionStorage.getItem("userId");

  constructor(private route: ActivatedRoute, private service:MenuService, private cartService:CartService) { 
    this.id = route.snapshot.params.id;
  }

  ngOnInit(): void {
    this.service.getMenuListByRestaurant(this.id).subscribe((data)=>{
      this.menuArrayByRestaurant=data;
    })
  }

  onAddToCart(obj:Menu){
    this.menu1.foodId=obj.foodId;
    this.user1.id=this.userId

    this.cart.menu=this.menu1;
    this.cart.user = this.user1;

    this.cartService.addToCart(this.cart).subscribe((data) =>{
      console.log(data);
    })
  }

}
