import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';

  userDetails = [
    { name: 'A', email: 'a@gmail.com' },
    { name: 'B', email: 'b@gmail.com' },
    { name: 'C', email: 'c@gmail.com' },
  ];

}
