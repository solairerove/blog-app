import {Component, OnInit} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';
import {Router} from 'angular2/router';

import {Post} from '../../model/post';
import {PostService} from '../../service/post.service';


@Component({
    selector: 'my-posts',
    templateUrl: '/app/components/posts/posts.component.html',
    providers: [PostService, HTTP_PROVIDERS]
})

export class PostsComponent implements OnInit {
    posts:Post[];
    errorMessage:string;

    constructor(private router:Router,
                private postsService:PostService) {

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

    gotoDetail(post:Post) {
        this.router.navigate(['PostDetail', {id: post.id}]);
    }
}
