import {Component, OnInit} from 'angular2/core';
import {PostService} from './post.service';
import {HTTP_PROVIDERS} from 'angular2/http';

import {Post} from './post';

@Component({
    selector: 'posts',
    templateUrl: 'app/posts.component.ts',
    providers: [PostService, HTTP_PROVIDERS]
})

export class PostsComponent implements OnInit {
    posts:Post[];
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
