import {Component, OnInit, Input} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';
import {ROUTER_DIRECTIVES, Router} from 'angular2/router';

import {PostService} from "../../service/post.service";
import {Post} from "../../model/post";

@Component({
    selector: 'my-post-add-component',
    templateUrl: '/app/components/post-add/post-add.component.html',
    providers: [
        PostService,
        HTTP_PROVIDERS
    ],
    directives: [ROUTER_DIRECTIVES]
})

export class PostAddComponent implements OnInit {

    @Input() post:Post;
    error:any;
    postAdded:boolean;
    data:string;

    constructor(private postService:PostService, private router:Router) {
        this.postAdded = false;
    }

    ngOnInit() {
        this.post = new Post();
    }

    save() {
        this.postService.save(this.post)
            .subscribe(data => this.data = JSON.stringify(data));
        this.postAdded = true;
    }
}