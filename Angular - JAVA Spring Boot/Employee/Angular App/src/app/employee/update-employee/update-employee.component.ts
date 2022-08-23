import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee.model';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  employee!: Employee;
  //employee!: Employee[];
  //employee:Employee[]=[];
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    console.log(id);
    this.employeeService.getEmployeesById(id).subscribe((data) => {
      this.employee = data;
    });
  }

  onSubmit(employee: Employee) {
    this.employeeService.updateEmployee(employee).subscribe(data => {
      this.router.navigate(["/employees"]);
    });
  }

  onCancel() {
    this.router.navigate(["/employees"])
  }

}
