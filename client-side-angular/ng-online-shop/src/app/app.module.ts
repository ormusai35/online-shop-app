import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule,Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { UserService } from './services/user.service';
import { ErrorComponent } from './components/error/error.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { NewProductComponent } from './components/new-product/new-product.component';
import { UserOrdersComponent } from './components/user-orders/user-orders.component';
import { AdminOrdersComponent } from './components/admin-orders/admin-orders.component';
import { AdminProductsComponent } from './components/admin-products/admin-products.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ProductsComponent } from './components/products/products.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { ProductsService } from './services/products.service';
import { ProductFilterComponent } from './components/products/product-filter/product-filter.component';
import { ProductCardComponent } from './components/products/product-card/product-card.component';
import { CartService } from './services/cart.service';
import { FooterComponent } from './components/footer/footer.component';

const appRoutes:Routes = [
  {path:'',component:HomePageComponent},
  {path:'shoppingcart',component:ShoppingCartComponent},
  {path:'products',component:ProductsComponent},
  {path:'myorders',component:UserOrdersComponent}, //, canActivate:[RouteguardService]},
  {path:'check-out',component:CheckoutComponent}, //, canActivate:[RouteguardService]},
  {path:'login',component:LoginComponent},
  {path:'login/signup',component:SignUpComponent},
  {path:'admin/products',component:AdminProductsComponent}, //, canActivate:[RouteguardService,AdminGaurdService]},
  {path:'admin/products/new',component:NewProductComponent}, //, canActivate:[RouteguardService,AdminGaurdService]},
  {path:'admin/products/:id',component:NewProductComponent}, //, canActivate:[RouteguardService,AdminGaurdService]},
  {path:'admin/orders',component:AdminOrdersComponent},  //,canActivate:[RouteguardService,AdminGaurdService]},
  {path:'**',component:ErrorComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    ErrorComponent,
    SignUpComponent,
    HomePageComponent,
    NewProductComponent,
    UserOrdersComponent,
    AdminOrdersComponent,
    AdminProductsComponent,
    CheckoutComponent,
    ProductsComponent,
    ShoppingCartComponent,
    ProductFilterComponent,
    ProductCardComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'})
  ],
  providers: [UserService,ProductsService,CartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
