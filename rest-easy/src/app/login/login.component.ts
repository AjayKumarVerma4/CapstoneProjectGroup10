import { Component, OnInit } from '@angular/core'
import { User } from '../model/user';
import { Router } from '@angular/router';

import {NgForm} from '@angular/forms';
import { Route } from '@angular/compiler/src/core';
import { CartService } from '../service/cart.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = new User();
  msg='';
  message:string="";
  flag:number=0;
  constructor(private _service :UserService, private _route:Router, private cartService: CartService) { }

  ngOnInit(): void {
  }

  //This method is used for seding the login data to the service for process
  loginUser(){
    console.log("login========",this.user)
    this._service.loginUserFromRemote(this.user).subscribe(
      data => 
      {
        this.flag=1;
        this.cartService.onLoginSuccess(data.firstName+" "+data.lastName , this.flag)
        // store
        localStorage.setItem("lastName", data.lastName );
        sessionStorage.setItem("userId", data.id);
        
        this._route.navigate(['']);
      },
      error =>{
         console.log("exceptions occured");
        this. msg="bad credentials";
      }
    )
   
  }
  
}
