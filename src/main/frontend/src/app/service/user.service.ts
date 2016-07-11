import {Injectable} from 'angular2/core';
import {Http, Response, Headers} from 'angular2/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';

import {Post} from '../model/post';
import {Constraints} from '../constraints/constraints';
import {User} from '../model/user';

@Injectable()
export class UserService {

    private url:string;
    private token:string;
    
    constructor(private http:Http) {
        this.url = Constraints.API_URL;
        this.token = "";
    }

    //TODO:fix response for post request
    authenticate(user:User) {
        var user = JSON.stringify(user);
        var headers = new Headers();
        headers.append('Content-type',
            'application/json');

        return this.http.post(this.url + "/authenticate", user, {
            headers:headers
        }).map(res=>res.json());
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
