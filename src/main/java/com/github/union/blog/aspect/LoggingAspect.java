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
    public void logBefore(JoinPoint joinPoint){
        logger.info("Finding all posts");
    }


}
