package com.github.solairerove.blog.controller;

import com.github.solairerove.blog.dto.LoginDTO;
import com.github.solairerove.blog.dto.TokenModel;
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
import javax.validation.Valid;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

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

//            Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
//            SecurityContext securityContext = SecurityContextHolder.getContext();
//            securityContext.setAuthentication(authentication);

            return new ResponseEntity<>(new TokenModel(token), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> currentUser(@Valid @RequestBody TokenModel tokenModel,
                                         HttpServletRequest request) throws Exception {

        String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(tokenModel.getToken())
                         .getBody().getSubject();

//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        Authentication authentication = securityContext.getAuthentication();
//        if (authentication != null) {
//            return (KikkoUser) authentication.getDetails();
//        }
//        return null;


        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("subject",subject);
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }
}
