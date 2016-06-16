package com.github.solairerove.blog.dto;

import java.io.Serializable;

/**
 * Created by vlad on 16.06.16.
 */
public class UserDTO implements Serializable {
    private String login;
    private String token;

    public UserDTO() {
    }

    public UserDTO(String login, String token) {
        this.login = login;
        this.token = token;
    }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }
}
