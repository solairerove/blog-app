import {Injectable} from "angular2/core";
import {Http, Response, Headers} from "angular2/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

import {Post} from "../model/post";
import {Token} from "../model/token"
import {Constraints} from '../constraints/constraints';
import {User} from "../model/user";

@Injectable()
export class UserService {

    private url:string;

    constructor(private http:Http) {
        this.url = Constraints.API_URL;
    }

    authenticate(user:User):Observable<Token> {
        return this.http.get(this.url + "/authenticate")
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

        return this.http.post(this.url, json, {
            headers: headers
        })
            .catch(this.handleError);
    }

    private handleError(error:Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}