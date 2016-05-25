import {Component} from 'angular2/core';
import {
    RouteConfig,
    ROUTER_DIRECTIVES,
    ROUTER_PROVIDERS
} from 'angular2/router';

import {PostService} from './post.service';
import {PostsComponent} from './posts.component';
import {AboutComponent} from './about.component';
import {PostDetailComponent} from './post-detail.component';

@RouteConfig([
    {
        path: '/posts',
        name: 'Posts',
        component: PostsComponent,
        useAsDefault: true
    },
    {
        path: '/about',
        name: 'About',
        component: AboutComponent
    },
    {
        path: '/posts/:id',
        name: 'PostDetail',
        component: PostDetailComponent
    },
    {
        path: '/**',
        redirectTo: ['Posts']
    }
])

@Component({
    selector: 'my-app',
    templateUrl: 'app/app.component.html',
    directives: [
        ROUTER_DIRECTIVES
    ],
    providers: [
        ROUTER_PROVIDERS,
        PostService
    ]
})

export class AppComponent {

}
