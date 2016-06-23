import {Component, OnInit, Input} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';
import {ROUTER_DIRECTIVES} from 'angular2/router';

@Component({
    selector: 'my-log-in-component',
    templateUrl: '/app/components/log-in/log-in.component.html',
    providers: [
        //PostService,
        HTTP_PROVIDERS
    ],
    directives: [ROUTER_DIRECTIVES]
})


export class LogInComponent{
    
}