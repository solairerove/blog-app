import {Component} from 'angular2/core';
import {PostService} from './post.service';

import {PostsComponent} from './posts.component';

@Component({
    selector: 'my-app',
    template: '<my-posts></my-posts>',
    directives: [PostsComponent],
    providers: [PostService]
})

export class AppComponent {

}
