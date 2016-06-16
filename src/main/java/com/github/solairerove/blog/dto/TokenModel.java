package com.github.solairerove.blog.dto;

import java.io.Serializable;

/**
 * Created by vlad on 16.06.16.
 */
public class TokenModel implements Serializable {
    private String token;

    public TokenModel() {
    }

    public TokenModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
