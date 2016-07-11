import {Component, OnInit} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';
import {RouteParams} from 'angular2/router';

import {CommentService} from '../../service/comment.service';
import {Comment} from '../../model/comment';


@Component({
    selector: 'my-comments',
    templateUrl: '/app/components/comments/comments.component.html',
    providers: [
        CommentService, 
        HTTP_PROVIDERS
    ]
})

export class CommentsComponent implements OnInit {
    comments:Comment[];
    errorMessage:string;

    constructor(private commentService:CommentService,
                private routeParams:RouteParams) {

    }

    ngOnInit() {
        let id = +this.routeParams.get('id');
        this.commentService.getPostComments(id)
            .subscribe(
                comments => this.comments = comments,
                error => this.errorMessage = <any> error
            );
    }

    goBack() {
        window.history.back();
    }
}