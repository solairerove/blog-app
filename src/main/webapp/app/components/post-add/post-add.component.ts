import {Component, OnInit} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';

import {PostService} from "../../service/post.service";

@Component({
    selector: 'my-post-add-component',
    templateUrl: '/app/components/post-add/post-add.component.html',
    providers: [
        PostService,
        HTTP_PROVIDERS
    ]
})

export class PostAddComponent {

    constructor(private postService:PostService) {

    }
    
    
}