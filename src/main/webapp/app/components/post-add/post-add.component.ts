import {Component, OnInit, Input} from 'angular2/core';
import {HTTP_PROVIDERS} from 'angular2/http';

import {PostService} from "../../service/post.service";
import {Post} from "../../model/post";

@Component({
    selector: 'my-post-add-component',
    templateUrl: '/app/components/post-add/post-add.component.html',
    providers: [
        PostService,
        HTTP_PROVIDERS
    ]
})

export class PostAddComponent {

    @Input() post: Post;
    error: any;

    constructor(private postService:PostService) {
        
    }

    save(){
        this.postService.save(this.post)
            .catch(error => this.error = error);
    }
    
    
    goBack() {
        window.history.back();
    }
}