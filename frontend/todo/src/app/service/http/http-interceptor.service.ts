import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { BasicAuthenticationService } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {

  constructor(
    private basicAuthService : BasicAuthenticationService
  ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler){
    let username = this.basicAuthService.getAuthenticatedUser();
    let basicAuthHeaderString =  this.basicAuthService.getAuthenticatedToken();

    if(username && basicAuthHeaderString){
      req = req.clone({
        setHeaders : {
          Authorization : basicAuthHeaderString
        }
      });
    }

    return next.handle(req);
  };
}
