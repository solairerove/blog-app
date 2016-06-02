# blog-app [![Build Status](https://travis-ci.org/solairerove/blog-app.svg?branch=master)](https://travis-ci.org/solairerove/blog-app)
[rest-blog.herokuapp.com](https://rest-blog.herokuapp.com)
##### TODO on client

* routing **implemented**
* bootstrap **implemented**
* post details **implemented**
* html content formatting **implemented**
* comment details **implemented**
* style comments **implemented**
* add new post 
* show comments button **implemented**
* posts pagination
* client as view of rest server **implemented**

___

##### TODO on server

* user and authority models **implemented**
* user and authority dto **implemented**
* additional repositories and services **implemented**
* aspectj **implemented**
* rename `authority` to `authority` **implemented**
* added email(uniq) **implemented**
* nickname and login ara uniq **implemented**
* many to many relation between user and authority **implemented**
* simple rest security filter **implemented**
* additional junit and mock
* OAuth2 implementation
* sign up controller
* update group in insomnia rest client
* [api doc generate](https://github.com/kongchen/swagger-maven-plugin#typesToSkip)
* mvn site generate
* `pagination, sort and filtering`
* `add findAll(Pageable page) service implementation`
___

##### Additional cookies

* `npm i -g json`
* `sudo apt-get install python-pygments`
* `curl 'http://localhost:8080/api/posts/' | json | pygmentize -l json`

___

##### Run server

* `mvn spring-boot:run`
or
* `mvn clean install`
* `java -jar target/*.jar`

___

##### Use H2 web console:

* `http://localhost:8080/console/`
* `jdbc:h2:mem:post`

___

#### Open in whatever rest client

* `http://localhost:8080/api/posts/1` - get post by id
* `http://localhost:8080/api/posts/` - get all posts
* `http://localhost:8080/api/posts?page=1&size=2` - get 2 elements from 1 page 
* `http://localhost:8080/api/posts` - add new post
* `http://localhost:8080/api/posts/5` - delete post by id
* `http://localhost:8080/api/posts` - update post content by id
* `http://localhost:8080/api/comments` - get all comments
* `http://localhost:8080/api/comments/1` - get comment by id
* `http://localhost:8080/api/comments` - update review by id
* `http://localhost:8080/api/comments/1` - delete comment by id
* `http://localhost:8080/api/posts/6/comments` - add new comment to post by id
* `http://localhost:8080/api/posts/1/comments` - get all comments from post by id

___

##### `@SpringBootApplication` is a convenience annotation that adds all of the following:
* `@Configuration` tags the class as a source of bean definitions for the application context.
* `@EnableAutoConfiguration` tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
* Normally you would add `@EnableWebMvc` for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a `DispatcherServlet`.
* `@ComponentScan` tells Spring to look for other components, configurations, and services in the package, allowing it to find the `GreetingController`.

___

##### The Spring Boot gradle plugin provides many convenient features:

* It collects all the jars on the classpath and builds a single, runnable `über-jar`, which makes it more convenient to execute and transport your service.
* It searches for the `public static void main()` method to flag as a runnable class.
* It provides a built-in dependency resolver that sets the version number to match Spring Boot dependencies. You can override any version you wish, but it will default to Boot’s chosen set of versions.

____
