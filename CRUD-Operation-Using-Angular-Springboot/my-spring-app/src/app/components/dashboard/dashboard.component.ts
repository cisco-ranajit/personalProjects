import { Component } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar'; 
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatDividerModule} from '@angular/material/divider';
import {MatTableModule} from '@angular/material/table';
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
    MatTableModule
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  displayedColumns: string[] = ['position', 'name', 'salary', 'symbol'];
  dataSource = ELEMENT_DATA;
}
export interface PeriodicElement {
  name: string;
  position: number;
  salary: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Ranajit', salary: 1.0079, symbol: 'H'},
  {position: 2, name: 'Bibhu', salary: 4.0026, symbol: 'He'},
  {position: 3, name: 'Subham', salary: 6.941, symbol: 'Li'},
  {position: 4, name: 'Sourav', salary: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Subrat', salary: 10.811, symbol: 'B'},
  {position: 6, name: 'Jagannat', salary: 12.0107, symbol: 'C'},
  {position: 7, name: 'Lalit', salary: 14.0067, symbol: 'N'},
  {position: 8, name: 'Amiya', salary: 15.9994, symbol: 'O'},
  {position: 9, name: 'Deepak', salary: 18.9984, symbol: 'F'},
  {position: 10, name: 'Pankaj', salary: 20.1797, symbol: 'Ne'},
];
