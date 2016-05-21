import {Component, OnInit} from 'angular2/core';
import {PostService} from './post.service';
import {Post} from './post';

@Component({
    selector: 'my-app',
    templateUrl: 'app/app.component.html',
    providers: [PostService]
})

export class AppComponent implements OnInit{
    posts: Post[];
    errorMessage: string;

    constructor(private _postService: PostService) {

    }

    ngOnInit() {
        this.getPosts();
    }

    getPosts() {
        this._postService.getPosts()
            .subscribe(
                posts => this.posts = posts,
                error => this.errorMessage = <any> error
            );
    }
}
