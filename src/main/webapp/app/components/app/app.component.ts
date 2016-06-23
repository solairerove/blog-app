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
import {Constraints} from '../../constraints/constraints';

@RouteConfig([
    {
        path: Constraints.POSTS_PATH,
        name: 'Posts',
        component: PostsComponent,
        useAsDefault: true
    },
    {
        path: Constraints.ABOUT_PATH,
        name: 'About',
        component: AboutComponent
    },
    {
        path: Constraints.POST_DETAIL_PATH,
        name: 'PostDetail',
        component: PostDetailComponent
    },
    {
        path: Constraints.ADD_POST_PATH,
        name: 'AddPost',
        component: PostAddComponent
    },
    {
        path: Constraints.LOG_IN_PATH,
        name: 'LogIn',
        component: PostAddComponent
    },
    {
        path: Constraints.OTHER,
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
