package com.github.solairerove.blog;

import com.github.solairerove.blog.service.CustomUserDetailsService;
import com.github.solairerove.blog.service.UserService;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * Created by union on 04.05.16.
 */
@SpringBootApplication
@ComponentScan("com.github.solairerove.blog")
//@EnableResourceServer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

//    @Configuration
//    @EnableAuthorizationServer
//    protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {
//
//        @Autowired
//        private AuthenticationManager authenticationManager;
//
//        @Override
//        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//            endpoints.authenticationManager(authenticationManager);
//        }
//
//        @Override
//        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//            security.checkTokenAccess("isAuthenticated()");
//        }
//
//        @Override
//        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//            clients.inMemory().withClient("my-trusted-client")
//                    .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                    .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT").scopes("read", "write", "trust")
//                    .resourceIds("oauth2-resource").accessTokenValiditySeconds(600).and()
//                    .withClient("my-client-with-registered-redirect").authorizedGrantTypes("authorization_code")
//                    .authorities("ROLE_CLIENT").scopes("read", "trust").resourceIds("oauth2-resource")
//                    .redirectUris("http://anywhere?key=value").and().withClient("my-client-with-secret")
//                    .authorizedGrantTypes("client_credentials", "password").authorities("ROLE_CLIENT").scopes("read")
//                    .resourceIds("oauth2-resource").secret("secret");
//        }
//    }
//
//    @Autowired
//    public void authenticationManager(AuthenticationManagerBuilder builder, UserService userService) throws Exception {
//        builder.userDetailsService(userDetailsService(userService));
//    }
//
//    private UserDetailsService userDetailsService(final UserService userService) {
//        return username -> new CustomUserDetailsService(userService.findUserByLogin(username));
//    }
}
