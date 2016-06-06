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

export class PostAddComponent implements OnInit {

    @Input() post:Post;
    data:string;
    error:any;

    constructor(private postService:PostService) {

    }

    ngOnInit() {
        this.post = new Post();
    }

    save() {
        this.postService.save(this.post).subscribe(
            data=>this.data = JSON.stringify(data),
            ()=>console.log("Post added")
        );
        alert(this.data);
    }

    goBack() {
        window.history.back();
    }
}