import {Component, OnInit} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';

import {PostService} from './post.service';

@Component({
    selector: 'my-posts',
    templateUrl: 'app/posts.component.html',
    providers: [PostService, HTTP_PROVIDERS]
})

export class PostsComponent implements OnInit {
    posts:Object[];
    errorMessage:string;

    constructor(private postsService:PostService) {

    }

    ngOnInit() {
        this.getPosts();
    }

    getPosts() {
        this.postsService.getPosts()
            .subscribe(
                posts => this.posts = posts,
                error => this.errorMessage = <any> error
            );
    }
}
