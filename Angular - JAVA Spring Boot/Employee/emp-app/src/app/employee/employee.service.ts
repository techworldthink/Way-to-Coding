import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import {Employee} from "./employee.model";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  getEmployees():Observable<Employee[]>{
    return this.http.get<Employee[]>("http://localhost:8080/employees");
  }

  addEmployee(employee:Employee):Observable<Employee>{
    return this.http.post<Employee>("http://localhost:8080/employees",employee);
  }

  getEmployeesById(id:number):Observable<Employee>{
    return this.http.get<Employee>("http://localhost:8080/employees/"+id);
  }

  updateEmployee(employee:Employee):Observable<Employee>{
    return this.http.put<Employee>("http://localhost:8080/employees/"+employee.id,employee);
  }

  deleteEmployee(id:number):Observable<Employee>{
    return this.http.delete<Employee>("http://localhost:8080/employees/"+id);
  }

}
