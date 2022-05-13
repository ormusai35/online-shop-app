import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminOrdersComponent } from './components/admin-orders/admin-orders.component';
import { AdminProductsComponent } from './components/admin-products/admin-products.component';
import { ErrorComponent } from './components/error/error.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/login/login.component';
import { NewProductComponent } from './components/new-product/new-product.component';
import { ProductsComponent } from './components/products/products.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { UserOrdersComponent } from './components/user-orders/user-orders.component';
import { AdminRouteGuard } from './guards/admin-route.guard';
import { RouteGaurd } from './guards/route.guard';

const appRoutes:Routes = [
  {path:'',component:HomePageComponent},
  {path:'shoppingcart',component:ShoppingCartComponent},
  {path:'products',component:ProductsComponent},
  {path:'myorders',component:UserOrdersComponent}, //, canActivate:[RouteguardService]},
  // {path:'check-out',component:CheckoutComponent}, //, canActivate:[RouteguardService]},
  {path:'login',component:LoginComponent},
  {path:'login/signup',component:SignUpComponent},
  {path:'admin/products',component:AdminProductsComponent, canActivate:[RouteGaurd,AdminRouteGuard]}, //, canActivate:[RouteguardService,AdminGaurdService]},
  {path:'admin/products/new',component:NewProductComponent, canActivate:[RouteGaurd,AdminRouteGuard]}, //, canActivate:[RouteguardService,AdminGaurdService]},
  {path:'admin/products/:id',component:NewProductComponent, canActivate:[RouteGaurd,AdminRouteGuard]}, //, canActivate:[RouteguardService,AdminGaurdService]},
  {path:'admin/orders',component:AdminOrdersComponent, canActivate:[RouteGaurd,AdminRouteGuard]},  //,canActivate:[RouteguardService,AdminGaurdService]},
  {path:'**',component:ErrorComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
