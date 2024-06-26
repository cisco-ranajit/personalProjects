import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-demo-page',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './demo-page.component.html',
  styleUrl: './demo-page.component.css'
})
export class DemoPageComponent {
  title : string | undefined;
  checkBox = 'checkbox';
  btnClass = 'btn btn-success';

  changeName (){
    this.title = "Hello world";
  }
}


