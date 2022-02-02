import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule,Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component'
import { LoginComponent } from './components/login/login.component';
import { UserService } from './services/user.service';
import { ErrorComponent } from './components/error/error.component';
import { SignUpComponent } from './components/sign-up/sign-up.component'




const appRoutes:Routes = [
  {path:'',component:HomeComponent},
  // {path:'shoppingcart',component:ShppoingcartComponent},
  // {path:'products',component:ProductsComponent},
  // {path:'myorders',component:MyordersComponent, canActivate:[RouteguardService]},
  // {path:'check-out',component:CheckoutComponent, canActivate:[RouteguardService]},
  {path:'login',component:LoginComponent},
  {path:'login/signup',component:SignUpComponent},
  // {path:'admin/products',component:AdminProductsComponent, canActivate:[RouteguardService,AdminGaurdService]},
  // {path:'admin/products/new',component:NewProductComponent, canActivate:[RouteguardService,AdminGaurdService]},
  // {path:'admin/products/:id',component:NewProductComponent, canActivate:[RouteguardService,AdminGaurdService]},
  // {path:'admin/orders',component:AdminOrdersComponent, canActivate:[RouteguardService,AdminGaurdService]},
  {path:'**',component:ErrorComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    ErrorComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule
    // ,ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'})
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
