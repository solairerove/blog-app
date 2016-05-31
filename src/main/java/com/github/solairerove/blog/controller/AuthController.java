package com.github.solairerove.blog.controller;

import com.github.solairerove.blog.dto.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by union on 31.05.16.
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    public ResponseEntity<?> authorize(@Valid @RequestBody LoginDTO loginDTO,
                                       HttpServletRequest request) throws AuthenticationException {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
