package com.github.solairerove.blog.security;

import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * Created by vlad on 19.06.16.
 */
@Component
public class SecurityProvider {

    private Key key;

    public SecurityProvider() {
        key = MacProvider.generateKey();
    }

    public SecurityProvider(Key key) {
        this.key = key;
    }

    public Key getTokenKey() {
        return key;
    }
}
