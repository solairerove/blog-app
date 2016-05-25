import {Component, OnInit} from 'angular2/core';
import {RouteParams} from 'angular2/router';

import {Post} from './post';
import {PostService} from './post.service';

@Component({
    selector: 'my-post-detail',
    templateUrl: 'app/post-detail.component.html'
})

export class PostDetailComponent implements OnInit {
    post:Post;

    constructor(private postService:PostService,
                private routeParams:RouteParams) {

    }

    ngOnInit() {
        let id = +this.routeParams.get('id');
        this.postService.getPost(id)
            .subscribe(post => this.post = post);
    }

    goBack() {
        window.history.back();
    }
}