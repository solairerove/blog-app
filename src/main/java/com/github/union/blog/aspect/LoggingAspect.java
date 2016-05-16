package com.github.union.blog.aspect;

import com.github.union.blog.service.impl.PostServiceImpl;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by vlad on 16.05.16.
 */
@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(PostServiceImpl.class);

    @Before("execution(* com.github.union.blog.service.PostService.findAll(..))")
    public void findAllLog(JoinPoint joinPoint){
        logger.info("Finding all posts");
    }

    @Before("execution(* com.github.union.blog.service.PostService.findOnePostById(..))")
    public void fingPostLog(JoinPoint joinPoint){
        logger.info("Find one post by id: " + joinPoint.getArgs()[0]);
    }

    @Before("execution(* com.github.union.blog.service.PostService.save(..))")
    public void savePostLog(JoinPoint joinPoint){
        logger.info("Save entity:" + joinPoint.getArgs()[0].toString());
    }


}
