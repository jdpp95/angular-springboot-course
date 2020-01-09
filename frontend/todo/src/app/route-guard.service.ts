import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { HardcodedAuthenticationService } from './service/hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private hcAuthService: HardcodedAuthenticationService, private router : Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    var authenticated = this.hcAuthService.isUserLoggedIn();

    if(!authenticated){
      this.router.navigate(['login']);
    }

    return authenticated;
  }

}
