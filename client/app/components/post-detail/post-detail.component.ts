import {Component, OnInit} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';
import {RouteParams} from 'angular2/router';

import {Post} from '../../../app/model/post';
import {PostService} from '../../service/post.service';
import {CommentsComponent} from '../comments/comments.component';
import {CommentService} from "../../service/comment.service";


@Component({
    selector: 'my-post-detail',
    templateUrl: '/app/components/post-detail/post-detail.component.html',
    directives: [
        CommentsComponent
    ],
    providers: [
        CommentService,
        PostService,
        HTTP_PROVIDERS
    ]
})

export class PostDetailComponent implements OnInit {
    post:Post;
    commentShow:boolean;

    constructor(private postService:PostService,
                private routeParams:RouteParams) {

    }

    switchCommentShow(){
        this.commentShow = !this.commentShow;
    }

    ngOnInit() {
        this.commentShow = false;
        let id = +this.routeParams.get('id');
        this.postService.getPost(id)
            .subscribe(post => this.post = post);
    }

    goBack() {
        window.history.back();
    }
}