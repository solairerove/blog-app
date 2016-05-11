# rest-blog

##### Run the wrapper script to perform the build task, just like you did previously:

`./gradlew build`

___

##### Then you can run the app!

`./gradlew bootRun`

___

##### To run html page:

* go to `public` folder
* open terminal
* `python -m SimpleHTTPServer`
* `http://localhost:8000/index.html#/`
___

#### To create db uncomment:

`spring.jpa.hibernate.ddl-auto=create` in `application.properties`
___

#### Open in whatever rest client

* `http://localhost:8080/api/post/2` - get post by id
```json
{
        "id": 2,
        "title": "new another",
        "subtitle": "this is new post",
        "content": "new content",
        "date": "2016-05-09",
        "author": "author of new post",
        "new": false
    }
```
* `http://localhost:8080/api/post/` - return all posts
* `http://localhost:8080/api/post/` - added new post
```json
{
    "title": "new another",
    "subtitle": "this is new post",
    "content": "text of new post",
    "author": "author of new post"
}
```
* `http://localhost:8080/api/post/1` - deleted post by id
* `http://localhost:8080/api/post/` - update(put) post content by id
```json
{
        "id": 2,
        "title": "new another",
        "subtitle": "this is new post",
        "content": "new content",
        "date": "2016-05-09",
        "author": "author of new post",
        "new": false
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
