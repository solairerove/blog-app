package com.github.solairerove.blog.dto;

import java.io.Serializable;

/**
 * Created by union on 31.05.16.
 */
public class LoginDTO implements Serializable {
    private String login;
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
