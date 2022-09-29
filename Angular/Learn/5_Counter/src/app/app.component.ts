import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';
  count = 0;
  counter(type: String) {
    (type === 'add') ? this.count++ : this.count--;
  }
}
