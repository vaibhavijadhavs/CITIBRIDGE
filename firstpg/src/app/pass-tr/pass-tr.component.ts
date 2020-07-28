import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-pass-tr',
  templateUrl: './pass-tr.component.html',
  styleUrls: ['./pass-tr.component.css']
})
export class PassTrComponent implements OnInit {

  constructor(private router:Router,private http:HttpClient) { }

  transactions:any
  ngOnInit(): void {
    let resp=this.http.get("http://localhost:8080/feeds")
    resp.subscribe((data)=>this.transactions=data);

  }

}
