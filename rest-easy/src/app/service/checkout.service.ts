import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Purchase } from '../model/purchase';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  private baseUrl = "http://localhost:8081/checkouts";

  constructor(private http:HttpClient) { }

  public checkoutFormPost(purchase:Purchase):Observable<any>
  {
    return this.http.post<any>(`${this.baseUrl}`+`/saveCheckout`,purchase);
  }
}
