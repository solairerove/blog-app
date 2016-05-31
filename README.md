# blog-app
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
* commits pagination
* posts pagination

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
* additional junit and mock
* jwt token implementation
* sign up controller
* update group in insomnia rest client
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

___

##### Run client

* `npm i` - first time to download dependencies
* `cd client/`
* `npm start`

___

##### Use H2 web console:

* `http://localhost:8080/console/`
* `jdbc:h2:mem:post`

___

#### Open in whatever rest client

* `http://localhost:8080/api/post/1` - get post by id
```json
{
    "id": 1,
    "title": "Man must explore, and this is exploration at its greatest.",
    "subtitle": "Problems look mighty small from 150 miles up.",
    "content": "<p>What was most significant about the lunar voyage was not that man set foot on the Moon.</p>",
    "date": "2016-05-11",
    "author": "union.one",
    "commentList": []
}
```

* `http://localhost:8080/api/post/` - return all posts

* `curl 'http://localhost:8080/api/posts?page=0&size=2' | json | pygmentize -l json` - return 2 elements from 0 page 

* `http://localhost:8080/api/post/` - added new post
```json
{
    "id": 1,
    "title": "Failure is not an option",
    "subtitle": "Many say exploration is part of our destiny.",
    "content": "MockFlow",
    "date": "2016-05-11",
    "author": "union.one"
}
```
* `http://localhost:8080/api/post/1` - deleted post by id

* `http://localhost:8080/api/post/` - update post content by id
```json
{
    "id": 1,
    "title": "Failure is not an option",
    "subtitle": "Many say exploration is part of our destiny.",
    "content": "new content",
    "date": "2016-05-11",
    "author": "union.one"
}
```

* `http://localhost:8080/api/comment/` - get all comment
```json
{
    "id": 1,
    "author": "I'm a great author",
    "review": "this is my another review",
    "date": "date",
    "postId": 2
}
```

* `http://localhost:8080/api/comment/1` - get comment by id
```json
{
    "id": 1,
    "author": "I'm a great author",
    "review": "this is my another review",
    "date": "date",
    "postId": 2
}
```

* `http://localhost:8080/api/comment/1` - update comment review by id
```json
{
    "id": 1,
    "author": "this is great author.",
    "review": "review update",
    "date": "date of great comment.",
    "postId": 1
}
```

* `http://localhost:8080/api/comment/1` - delete comment by id

* `http://localhost:8080/api/post/1/comment` - add new comment to post by id
```json
{
    "id": 1,
    "author": "I'm a great author",
    "review": "this is my another review",
    "date": "date",
    "postId": 2
}
```

* `http://localhost:8080/api/post/1/comment` - get all comments from post by id
```json
{
    "id": 1,
    "author": "I'm a great author",
    "review": "this is my another review",
    "date": "date",
    "postId": 2
}
```

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
