import {Component, OnInit, Input} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';
import {ROUTER_DIRECTIVES} from 'angular2/router';
import {User} from "../../model/user";
import {UserService} from "../../service/user.service";

@Component({
    selector: 'my-log-in-component',
    templateUrl: '/app/components/log-in/log-in.component.html',
    providers: [
        UserService,
        HTTP_PROVIDERS
    ],
    directives: [ROUTER_DIRECTIVES]
})


export class LogInComponent implements OnInit {

    @Input() user:User;
    error:any;
    token:string;

    constructor(private userService:UserService) {
    }

    ngOnInit() {
        this.user = new User();
    }

    authenticate() {
        this.userService.authenticate(this.user)
            .subscribe(data => this.token = JSON.stringify(data));
        console.log(this.token);
    }
}