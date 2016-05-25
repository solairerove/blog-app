import {Component, OnInit} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';
import {RouteParams} from 'angular2/router';

import {Post} from '../../../app/model/post';
import {PostService} from '../../service/post.service';


@Component({
    selector: 'my-post-detail',
    templateUrl: '/app/components/post-detail/post-detail.component.html',
    providers: [
        PostService,
        HTTP_PROVIDERS
    ]
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