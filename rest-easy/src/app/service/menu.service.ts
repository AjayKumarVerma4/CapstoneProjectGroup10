import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from '../model/menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private baseUrl = "http://localhost:8081/menus";

  constructor(private http:HttpClient) { }

  getMenuList(): Observable<Menu[]>{
    return this.http.get<Menu[]>(`${this.baseUrl}`+`/menuList`);
  }

  getMenuListByRestaurant(id:any): Observable<Menu[]>{
    return this.http.get<Menu[]>(`${this.baseUrl}`+`/getMenuByRestaurantId/${id}`);
  }
}
