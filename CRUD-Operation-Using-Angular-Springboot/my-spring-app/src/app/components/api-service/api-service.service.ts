import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {
  private baseUrl = 'http://localhost:9090/api/employees';

  constructor(private httpClient: HttpClient) { }

  createEmployeeProfile(employee : Employee): Observable<Employee> {
    const header = new HttpHeaders({'Content-Type': 'application/json'})
    return this.httpClient.post<Employee>(`${this.baseUrl}/add`, employee, {headers:header});
  }

  getEmployeeList() : Observable<Employee>{
    return this.httpClient.get<Employee>(this.baseUrl);
  }

  deleteEmployeeProfile(id : number) : Observable<void>{
    return this.httpClient.delete<void>(`${this.baseUrl}/delete/${id}`);
  }
}
