import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';

  data = 1231;
  changevalue() {
    this.data = Math.floor(Math.random()*10);
  }

}
