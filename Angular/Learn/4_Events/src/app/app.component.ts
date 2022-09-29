import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';

  btnClick() {
    alert('Button click!');
  }

  btnClick2(msg: String) {
    alert(msg);
  }

  getData(msg: String) {
    console.log(msg);
  }

  msg:String='';
  showData(msg: String) {
    this.msg=msg;
  }

}
