import {Injectable} from "angular2/core";
import {Http, Response} from "angular2/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";
import {Comment} from "../model/comment";

@Injectable()
export class CommentService{
    
    private url:string;
    
    constructor(private http:Http){
        this.url='http://localhost:8080/api/posts/'
    }
    
    getPostComments(id):Observable<Comment[]>{
        return this.http.get(this.url + id + '/'
            + 'comments')
            .map(res => res.json())
            .catch(this.handleError);
    }
    
    private handleError(error:Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }    
}
