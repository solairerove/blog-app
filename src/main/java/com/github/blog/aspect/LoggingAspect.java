package com.github.blog.aspect;

import com.github.blog.dto.PostDTO;
import com.github.blog.service.impl.PostServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by union on 17.05.16.
 */

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    @Before("execution(* com.github.blog.service.PostService.findAll(..))")
    public void findAllLog(JoinPoint joinPoint) {
        logger.info("Finding all posts");
    }

    @Before("execution(* com.github.blog.service.PostService.findOnePostById(..))")
    public void fingPostLog(JoinPoint joinPoint) {
        logger.info("Find one post by id: " + joinPoint.getArgs()[0]);
    }

    @Before("execution(* com.github.blog.service.PostService.save(..))")
    public void savePostLog(JoinPoint joinPoint) {
        logger.info("Save entity:" + joinPoint.getArgs()[0].toString());
    }

    @After("execution(* com.github.blog.service.PostService.deletePostById(..))")
    public void deletePostLog(JoinPoint joinPoint) {
        logger.info("Deleting entity by id:" + joinPoint.getArgs()[0]);
    }

    @Before("execution(* com.github.blog.service.PostService.updateContentById(..))")
    public void updateContentLog(JoinPoint joinPoint) {
        logger.info("Updating post content with id:" + ((PostDTO) (joinPoint.getArgs()[0])).getId());
    }
}
