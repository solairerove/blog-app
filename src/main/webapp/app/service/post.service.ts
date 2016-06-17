import {Injectable} from "angular2/core";
import {Http, Response, Headers} from "angular2/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

import {Post} from "../model/post";
import {Constraints} from '../constraints/constraints';

@Injectable()
export class PostService {

    private url:string;
    private postUrl:string;

    constructor(private http:Http) {
        this.url = Constraints.POST_URL;
        this.postUrl = Constraints.POST_URL;
    }

    getPosts():Observable<Post[]> {
        return this.http.get(this.url)
            .map(res => res.json())
            .catch(this.handleError);
    }

    getPost(id):Observable<Post> {
        return this.http.get(this.url + "/" + id)
            .map(res => res.json())
            .catch(this.handleError);
    }

    save(post:Post) {
        var json = JSON.stringify(post);
        var headers = new Headers();
        headers.append('Content-type',
            'application/json');

        return this.http.post(this.postUrl, json, {
                headers: headers
            })
            .catch(this.handleError);
    }

    private handleError(error:Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}
