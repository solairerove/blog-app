import {Component, OnInit, Input} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';
import {ROUTER_DIRECTIVES} from 'angular2/router';

import {User} from '../../model/user';
import {UserService} from '../../service/user.service';
import {UserStorage} from '../../storage/user.storage';

@Component({
    selector: 'my-log-in-component',
    templateUrl: '/app/components/log-in/log-in.component.html',
    providers: [
        UserService,
        UserStorage,
        HTTP_PROVIDERS
    ],
    directives: [ROUTER_DIRECTIVES]
})

export class LogInComponent implements OnInit {

    @Input() user:User;
    error:any;

    constructor(private userService:UserService, 
                private userStorage:UserStorage) {
    }

    ngOnInit() {
        this.user = new User();
    }

    authenticate() {
        this.userService.authenticate(this.user)
            .subscribe(data => {
                this.userStorage.SetToken(data);
            });
    }
}