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
import { ProductsComponent } from './components/products/products.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { ProductsService } from './services/products.service';
import { ProductFilterComponent } from './components/products/product-filter/product-filter.component';
import { ProductCardComponent } from './components/products/product-card/product-card.component';
import { CartService } from './services/cart.service';
import { FooterComponent } from './components/footer/footer.component';
import { RouteGuardService } from './services/route-guard.service';
import { RouteGaurd } from './guards/route.guard';
import { ProductInCartComponent } from './components/product-in-cart/product-in-cart.component';



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
    // CheckoutComponent,
    ProductsComponent,
    ShoppingCartComponent,
    ProductFilterComponent,
    ProductCardComponent,
    FooterComponent,
    ProductInCartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'})
  ],
  providers: [UserService,ProductsService,CartService,RouteGaurd],
  bootstrap: [AppComponent]
})
export class AppModule { }
