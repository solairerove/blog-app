package com.github.solairerove.blog.dto;

import com.github.solairerove.blog.domain.Authority;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vlad on 16.06.16.
 */
public class UserDTO implements Serializable {
    private Long id;
    private String nickname;
    private String email;
    private String login;
    private List<Authority> authorities;

    public UserDTO() {
    }

    public UserDTO(String nickname, String email, String login,List<Authority> authorities) {
        this.nickname = nickname;
        this.email = email;
        this.login = login;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
