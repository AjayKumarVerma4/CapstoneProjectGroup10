import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../model/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private baseUrl = "http://localhost:8081/restaurants";

  constructor(private http:HttpClient) { }

  getRestaurantList(): Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(`${this.baseUrl}`+`/restaurantList `);
  }

}
