import {Token} from "../model/token";
import {Injectable} from "angular2/core";

@Injectable()
export class UserStorage {
    private token:Token;
    private nickname:string;


    SetToken(token:Token) {
        this.token = token;
    }

    GetToken() {
        return this.token;
    }

    setNickname(nickname:string) {
        this.nickname = nickname;
    }

    getNickname() {
        return this.nickname;
    }
}

