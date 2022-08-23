import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './employee/add-employee/add-employee.component';
import { DeleteEmployeeComponent } from './employee/delete-employee/delete-employee.component';
import { EmployeeComponent } from './employee/employee/employee.component';
import { UpdateEmployeeComponent } from './employee/update-employee/update-employee.component';

const routes: Routes = [
  {path:"employees",component:EmployeeComponent},
  {path:"add",component:AddEmployeeComponent},
  {path:"update/:id",component:UpdateEmployeeComponent},
  {path:"delete/:id",component:DeleteEmployeeComponent},
  {path:"",redirectTo:"employees",pathMatch:"full"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
