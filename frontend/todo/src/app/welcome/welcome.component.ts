import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  name = ''; 
  message: string = 'Welcome' + this.name;
  messageFromService: string
  errorMessage: string;
  errorInService:boolean = false;

  constructor(
    private route: ActivatedRoute, 
    private service: WelcomeDataService) { }

  ngOnInit() {
    this.name = this.route.snapshot.params['name'];
  }

  getWelcomeMessage() {
    this.service.executeHelloWorldBeanService().subscribe(
      response => this.handleSuccesfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

  getWelcomeMessageWithParameter() {
    this.service.executeHelloWorldBeanServiceWithPathVariable(this.name).subscribe(
      response => this.handleSuccesfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

  handleSuccesfulResponse(response) {
    this.errorInService = false;
    this.messageFromService = response.message;
  }

  handleErrorResponse(error){
    this.errorInService = true;
    this.errorMessage = error.error.message;
    if(!this.errorMessage) this.errorMessage = "Unknown error!"
  }
}
