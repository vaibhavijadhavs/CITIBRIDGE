import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private router:Router,private http:HttpClient) { }

  users:any
  

  ngOnInit(): void {
    let resp=this.http.get("http://localhost:8080/feeds")
    resp.subscribe((data)=>this.users=data);
 
  }

 /* uploadedFiles(){
    this.router.navigate(['/admin']);
  }*/
}
