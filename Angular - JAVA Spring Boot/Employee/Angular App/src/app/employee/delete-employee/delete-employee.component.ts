import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee.model';

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {
  //employee!: Employee[];
  employee!:Employee;
 // employee:Employee[]=[];
 //employee: Employee = new Employee();
  constructor(private employeeService:EmployeeService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    let id=this.route.snapshot.params['id'];
    this.employeeService.getEmployeesById(id).subscribe(data=>{
      this.employee=data;
    });
  }

  onDelete(){
    this.employeeService.deleteEmployee(this.employee.id).subscribe(data=>{
      this.router.navigate(["/employees"]);
    });
  }

  onCancel(){
    this.router.navigate(["/employees"])
  }

}
