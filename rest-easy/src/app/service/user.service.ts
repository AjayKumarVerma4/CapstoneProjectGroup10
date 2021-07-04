import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "http://localhost:8081/users";

  constructor(private http:HttpClient) { }

   //Method is used to send the gogin data to different Origin
   public loginUserFromRemote(user:User):Observable<any>{
    return this.http.post<any>(`${this.baseUrl}`+`/getUser`,user)
  }

  //Method for posting the data to the different origin
  public registerUserFromRemote(user:User):Observable<any>
  {
    return this.http.post<any>(`${this.baseUrl}`+`/addUser`,user);
  }

  //Method for getting user by id
  getUserById(id:any): Observable<User>{
    return this.http.get<User>(`${this.baseUrl}`+`/getUserById/${id}`);
  }

  handleError(error : Response)
  { }

}
