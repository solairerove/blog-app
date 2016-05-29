import {Component, OnInit} from "angular2/core";
import {HTTP_PROVIDERS} from "angular2/http";
import {Router} from "angular2/router";

import {CommentService} from "../../service/comment.service";
import {Comment} from "../../model/comment";


@Component({
    selector: 'my-comments',
    templateUrl: '/app/components/comments/comments.component.html',
    providers: [CommentService, HTTP_PROVIDERS]
})

export class CommentComponent implements OnInit {
    comments:Comment[];
    errorMessage:string;

    constructor(private router:Router,
                private commentService:CommentService) {

    }

    ngOnInit() {
    }

    getComments(postId) {
        this.commentService.getPostComments(postId)
            .subscribe(
                comments => this.comments = comments,
                error => this.errorMessage = <any> error
            );
    }
}