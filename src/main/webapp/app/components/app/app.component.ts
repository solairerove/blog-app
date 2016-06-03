import {Component} from 'angular2/core';
import {
    RouteConfig,
    ROUTER_DIRECTIVES,
    ROUTER_PROVIDERS
} from 'angular2/router';

import {PostService} from '../../service/post.service';
import {PostsComponent} from '../../components/posts/posts.component';
import {AboutComponent} from '../../components/about/about.component';
import {FooterComponent} from '../../components/footer/footer.component';
import {PostDetailComponent} from '../../components/post-detail/post-detail.component';
import {PostAddComponent} from '../../components/post-add/post-add.component';

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
        path:'/add',
        name: 'PostAddComponent',
        component: PostAddComponent
    },
    {
        path: '/**',
        redirectTo: ['Posts']
    }
])

@Component({
    selector: 'my-app',
    templateUrl: '/app/components/app/app.component.html',
    directives: [
        FooterComponent,
        ROUTER_DIRECTIVES
    ],
    providers: [
        ROUTER_PROVIDERS,
        PostService
    ]
})

export class AppComponent {

}
