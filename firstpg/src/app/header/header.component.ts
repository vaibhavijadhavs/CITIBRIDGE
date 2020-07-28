import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service'
@Component({
	selector: 'app-header',
	templateUrl: './header.component.html',
	styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

	username = 'citiAdmin'
	password = ''
	invalidLogin = false

	constructor(private router: Router,
		private loginservice: AuthenticationService) { }

	ngOnInit() {
	}

	checkLogin() {
		if (this.loginservice.authenticate(this.username, this.password)) {
			this.router.navigate(['/admin'])
			this.invalidLogin = false
		} else
			this.invalidLogin = true
	}

}
