import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
user= new User();
msg='';

  constructor(private _service : UserService, private _router : Router) { }

  ngOnInit(): void {
  }
//Used for sending the data to the Register service 
  registerUser()
  {
  this._service .registerUserFromRemote(this.user).subscribe(
  data =>{
    alert("Registered Successfully!");
    this._router.navigate(['']);
    
  },
  error => {
  this.msg=error.error;
    
  }
  
)
  }
}
