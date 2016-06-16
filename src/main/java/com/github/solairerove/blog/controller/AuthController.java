package com.github.solairerove.blog.controller;

import com.github.solairerove.blog.domain.User;
import com.github.solairerove.blog.dto.LoginDTO;
import com.github.solairerove.blog.dto.TokenModel;
import com.github.solairerove.blog.dto.UserDTO;
import com.github.solairerove.blog.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Key;

/**
 * Created by union on 31.05.16.
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private Key key = MacProvider.generateKey();

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginDTO loginDTO,
                                          HttpServletRequest request) throws AuthenticationException {
        if (userService.findUserByLogin(loginDTO.getLogin()) != null) {
            String token = Jwts.builder().setSubject(loginDTO.getLogin()).
                    signWith(SignatureAlgorithm.HS512, key).compact();

            return new ResponseEntity<>(new TokenModel(token), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> currentUser(HttpServletRequest request) throws Exception {
        try {
            String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(request.getHeader("Rest-Token"))
                    .getBody().getSubject();

            UserDTO response = new UserDTO();

            User currentUser = userService.findUserByLogin(subject);

            //FIXME fix authority json mapping
            //response.setAuthorities(currentUser.getAuthorities());
            response.setEmail(currentUser.getEmail());
            response.setLogin(currentUser.getLogin());
            response.setId(currentUser.getId());
            response.setNickname(currentUser.getNickname());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<?> logout(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        try {
            String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(request.getHeader("Rest-Token"))
                    .getBody().getSubject();

            //TODO: fix it if we want session, if not logout mech will be on client side
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
