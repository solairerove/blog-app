# [blog-app](https://rest-blog.herokuapp.com)
[![Build Status](https://travis-ci.org/solairerove/blog-app.svg?branch=master)](https://travis-ci.org/solairerove/blog-app)
[![Coverage Status](https://coveralls.io/repos/github/solairerove/blog-app/badge.svg?branch=master)](https://coveralls.io/github/solairerove/blog-app?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/576d19144fa522002a240cff/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/576d19144fa522002a240cff)
___

##### Additional cookies:

* `npm i -g json`
* `sudo apt-get install python-pygments`
* `curl 'http://localhost:8080/api/posts/' | json | pygmentize -l json`

___

##### Run server:

* `mvn spring-boot:run`
* `mvn clean install`
* `java -jar target/*.jar`

___

##### Run separate client:

* `cd src/main/frontend`
* `gulp clean && gulp build`
* `npm start`

___

##### Use H2 [web console](https://github.com/solairerove/blog-app/blob/master/src/main/java/com/github/solairerove/blog/config/H2Configuration.java):

* `http://localhost:8080/console/`
* `jdbc:h2:mem:post`

___

##### Generate Maven Site:

* `mvn site`
* `target/site/index.html`

___

##### Generate [Api doc](https://github.com/solairerove/blog-app/blob/master/pom.xml#L176-L216):

* `mvn clean compile`
* `target/generated/document.html`

___

##### [coveralls-maven-plugin](https://github.com/solairerove/blog-app/blob/master/pom.xml#L219-L252):

* `mvn clean test jacoco:report`
* `target/site/jacoco/index.html`
* `mvn clean test jacoco:report coveralls:report`

___

#### Open in whatever rest client:

* `http://localhost:8080/api/posts/1` - get post by id
* `http://localhost:8080/api/posts/` - get all posts
* `http://localhost:8080/api/posts` - add new post
* `http://localhost:8080/api/posts/1` - delete post by id
* `http://localhost:8080/api/posts` - update post content by id
* `http://localhost:8080/api/comments` - get all comments
* `http://localhost:8080/api/comments/1` - get comment by id
* `http://localhost:8080/api/comments` - update review by id
* `http://localhost:8080/api/comments/1` - delete comment by id
* `http://localhost:8080/api/posts/1/comments` - add new comment to post by id
* `http://localhost:8080/api/posts/1/comments` - get all comments from post by id
* `http://localhost:8080/api/authenticate` - authenticate user
* `http://localhost:8080/api/user` - get current user
* `http://localhost:8080/api/logout` - logout

___

##### `@SpringBootApplication` is a convenience annotation that adds all of the following:
* `@Configuration` tags the class as a source of bean definitions for the application context.
* `@EnableAutoConfiguration` tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
* Normally you would add `@EnableWebMvc` for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a `DispatcherServlet`.
* `@ComponentScan` tells Spring to look for other components, configurations, and services in the package, allowing it to find the `GreetingController`.

___

##### Security is provided by [JWT](https://jwt.io/) based library [jjwt](https://github.com/jwtk/jjwt)
 Easy to configure, easy to use. When user trying to log in, backend can give him a token, which he can use in the future requests. Each request after user authorization should contain token in header. It allow backend to understand authorities of each user. There is no session, so it's stateless implementation. Library [jjwt](https://github.com/jwtk/jjwt) is easy
 to integrate, token generation looks like:
 
```java
String token = Jwts.builder().setSubject(loginDTO.getLogin())
                   .signWith(SignatureAlgorithm.HS512, provider.getTokenKey()).compact();
```

Token parsing:

```java
String subject = Jwts.parser().setSigningKey(provider.getTokenKey())
                     .parseClaimsJws(request.getHeader("Rest-Token"))
                     .getBody().getSubject();
```

Token will contain login of authenticated user, so backend will load it's authorities by login from database.
___

##### Cookies with decreasing repo size: 

* To see the 10 biggest files, run this from the root directory:
```shell
git verify-pack -v .git/objects/pack/*.idx | sort -k 3 -n | tail -10
```

* To see what each file is, run this:
```shell
git rev-list --objects --all | grep [fiew symbols]
```

* Fuck this big files:
```shell
git filter-branch --index-filter 'git rm --cached --ignore-unmatch *.format' -- --all
rm -Rf .git/refs/original
rm -Rf .git/logs/
git gc --aggressive --prune=now
```

* Push to repo:
```shell
git push origin -f
```

___

##### Dark side, father:

* [liferay client](https://github.com/solairerove/liferay-blog-client) Client part of liferay-integrated blog
* [liferay rest](https://github.com/vlsidlyarevich/liferay-blog-backend) Backend part of liferay-integrated blog
