import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';

@Injectable()
export class PostService {

    private postsUrl = 'http://localhost:8080/api/post/';

    constructor(private http:Http) {
    }

    getPosts():Observable<Object[]> {
        return this.http.get(this.postsUrl)
            .map(res => res.json())
            .catch(this.handleError);
    }

    private handleError(error:Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}
