import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';
  users = [
    { name: 'A', acc: ['FB', 'Gmail'] },
    { name: 'B', acc: ['FB', 'Gmail','Whatsapp'] }];
}
