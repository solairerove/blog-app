package com.github.solairerove.blog.dto;

import com.github.solairerove.blog.domain.Authority;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {

    private Integer id;
    private String nickname;
    private String email;
    private String login;
    private String password;
    private List<Authority> authorities;

    UserDTO(){}

    public UserDTO(Integer id, String nickname, String email, String login, String password, List<Authority> authorities) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
