import { Component, OnInit, inject } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatTableModule } from '@angular/material/table';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/employee.model';
import { ApiServiceService } from '../api-service/api-service.service';
@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    MatToolbarModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatDividerModule,
    MatTableModule,
    FormsModule,
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {
  employees : Employee [] = [];
  httpClient = inject(HttpClient);
  displayedColumns: string[] = ['no', 'name', 'salary', 'address', 'job_profile', 'actions'];
  employeeForm = {
    empName: '',
    salary: '',
    address: '',
    job_profile: ''
  }

  constructor(private service : ApiServiceService){}

  ngOnInit(): void {
    this.getEmployeeList();
    throw new Error('Method not implemented.');
  }

  getEmployeeList() : void{
    this.service.getEmployeeList().subscribe((data : any) => {
      this.employees = data;
    })
  }

  createEmployeeProfile(): void {
    const newEmployee: Employee ={
      empName: this.employeeForm.empName,
      salary: this.employeeForm.salary,
      address: this.employeeForm.address,
      job_profile: this.employeeForm.job_profile
    }
    this.service.createEmployeeProfile(newEmployee).subscribe((data : any) => {
      console.log(data);
      this.employees.push(data);
      this.employeeForm ={
        empName: '',
        salary: '',
        address: '',
        job_profile: ''
      };
    })
  }
}