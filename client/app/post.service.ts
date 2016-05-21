import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Post} from './post';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';

@Injectable()
export class PostService {
    constructor(private http:Http) {
    }

    private _postsUrl = 'http://localhost:8080/api/post/';

    getPosts() {
        return this.http.get(this._postsUrl)
            .map(res => <Post[]> res.json())
            .catch(this.handleError);
    }

    private handleError(error:Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}
