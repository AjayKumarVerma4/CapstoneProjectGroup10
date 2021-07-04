import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../model/cart';
import { CartDTO } from '../model/cartDTO';
import { Menu } from '../model/menu';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  loginSuccessUser:string=""
  flag:number=0;

  private baseUrl = "http://localhost:8081/carts";

  constructor(private http:HttpClient) { }

  getCartItemListByUserId(userId:any): Observable<CartDTO[]>{
    return this.http.get<CartDTO[]>(`${this.baseUrl}`+`/getCartByUserId//${userId}`);
  }

  public addToCart(cart:Cart):Observable<any>
  {
    return this.http.post<any>(`${this.baseUrl}`+`/addToCart`,cart);
  }

  public onLoginSuccess(data:string,flag:number){
    this.flag=flag;
    this.loginSuccessUser=data;
  }
  //Used for fetching the name of logged in user
  public getLoginSuccess():string{
    return this.loginSuccessUser;
  }
  public getSuccessFlag():number{
    return this.flag;
  }
}
