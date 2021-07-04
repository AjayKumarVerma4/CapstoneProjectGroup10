import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BodyComponent } from './body/body.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { LoginComponent } from './login/login.component';
import { MenuByRestaurantComponent } from './menu-by-restaurant/menu-by-restaurant.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {path:"", redirectTo:"/home",pathMatch:"full"},
  {path:"home" , component: BodyComponent},
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'menuByRestaurant/:id', component: MenuByRestaurantComponent },
  { path: 'cart', component: CartComponent },
  { path: 'checkout', component: CheckoutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
