import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';

  list: any[] = [];

  addTask(task: String) {
    //console.log(task);
    this.list.push({id:this.list.length,name:task});
    //console.log(this.list);
  }

  removeTask(id:number){
    this.list=this.list.filter(item=>item.id!==id)
  }

}
