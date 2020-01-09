import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';
import { BasicAuthenticationService } from '../service/basic-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'someuser';
  password = '';
  errorMessage = 'Invalid credentials';
  invalidLogin = false;

  constructor(private router: Router,
    private hardCodedAuthService : HardcodedAuthenticationService,
    private basicAuthService : BasicAuthenticationService) { 
      
    }

  ngOnInit() {
  }

  handleLogin() {
    this.invalidLogin = !this.hardCodedAuthService.authenticate(this.username, this.password)
    if(!this.invalidLogin){
      this.router.navigate(['welcome',this.username]);
    }
  }

  // handleBasicAuthLogin() {
  //   this.basicAuthService.executeAuthenticationService(this.username, this.password).subscribe(
  //     data => {
  //       this.invalidLogin = false;
  //       this.router.navigate(['welcome',this.username]);
  //     },

  //     error => {
  //       this.invalidLogin = true;
  //     }
  //   );
  // }

  handleJWTAuthLogin() {
    this.basicAuthService.executeJWTAuthenticationService(this.username, this.password).subscribe(
      data => {
        this.invalidLogin = false;
        this.router.navigate(['welcome',this.username]);
      },

      error => {
        this.invalidLogin = true;
      }
    );
  }

}
