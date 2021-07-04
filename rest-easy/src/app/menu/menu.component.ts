import { Component, OnInit } from '@angular/core';
import { Cart } from '../model/cart';
import { Menu } from '../model/menu';
import { User } from '../model/user';
import { CartService } from '../service/cart.service';
import { MenuService } from '../service/menu.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  arr:Array<Menu>=[];

   fId:number=0;

  cart = new Cart();
  menu1 = new Menu();
  user1 = new User();
  userId:any=sessionStorage.getItem("userId");

  constructor(private service:MenuService, private cartService:CartService) { }

  ngOnInit(): void {
    this.service.getMenuList().subscribe((data)=>{
      this.arr=data;
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

  isAdded(obj: Menu) {
    return obj.foodId === this.fId;
  }

}
