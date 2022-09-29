import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';
  users=['A','B','C'];
  userDetails = [
    {name:'A',email:'a@gmail.com',phone:'111'},
    {name:'B',email:'b@gmail.com',phone:'222'},
    {name:'C',email:'c@gmail.com',phone:'333'},
  ];
}
