import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-failed-tr',
  templateUrl: './failed-tr.component.html',
  styleUrls: ['./failed-tr.component.css']
})
export class FailedTrComponent implements OnInit {

  constructor(private router:Router,private http:HttpClient) { }

  failedTr:any
  ngOnInit(): void {
    let resp=this.http.get("http://localhost:8080/feeds")
    resp.subscribe((data)=>this.failedTr=data);
  }

}
