import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';

import {Post} from './post';

@Injectable()
export class PostService {

    private url:string;

    constructor(private http:Http) {
        this.url = 'http://localhost:8080/api/posts'
    }

    getPosts():Observable<Post[]> {
        return this.http.get(this.url)
            .map(res => res.json())
            .catch(this.handleError);
    }

    getPost(id):Observable<Post> {
        return this.http.get(this.url + id)
            .map(res => res.json())
            .catch(this.handleError);
    }

    private handleError(error:Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}
