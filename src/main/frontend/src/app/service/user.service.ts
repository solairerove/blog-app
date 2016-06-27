import {Injectable} from "angular2/core";
import {Http, Response, Headers} from "angular2/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

import {Post} from "../model/post";
import {Token} from "../model/token"
import {Constraints} from '../constraints/constraints';
import {User} from "../model/user";
import {toPromise} from "rxjs/operator/toPromise";

@Injectable()
export class UserService {

    private url:string;
    private token:string;

    private adata:string;

    constructor(private http:Http) {
        this.url = Constraints.API_URL;
        this.token = "";
    }

    postJson() {
        var json = JSON.stringify({var1: 'test', var2: 3});
        var params = 'json=' + json;
        var headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        return this.http.post('http://validate.jsontest.com', params, {
            headers: headers
        }).map(res=>res.json());

        // return this.http.get('http://date.jsontest.com')
        //     .map(res=>res.json());
    }

    //TODO:fix response for post request
    authenticate(user:User) {
        // var json = JSON.stringify({var1:'test',var2:3});
        // var params = 'json=' + json;
        // var headers = new Headers();
        // headers.append('Content-Type','application/x-www-form-urlencoded');
        // this.http.post('http://validate.jsontest.com',params,{
        //     headers:headers
        // })
        // .toPromise()
        // .then(res => res.json().data)
        //     .then(data => this.adata = JSON.stringify(data));

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