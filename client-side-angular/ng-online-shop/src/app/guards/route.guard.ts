import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { UserService } from "../services/user.service";

@Injectable()
export class RouteGaurd implements CanActivate{

    constructor(private userService: UserService, private router: Router){ }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        console.log("login guard")
        return this.userService.isUserLogin();
    }
}