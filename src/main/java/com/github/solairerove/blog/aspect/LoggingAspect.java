package com.github.solairerove.blog.aspect;

import org.aspectj.lang.JoinPoint;
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

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.github.solairerove.blog.service.PostService.*(..)))")
    public void postServiceLog(JoinPoint joinPoint) {
        logger.info("Post service : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.blog.service.UserService.*(..))")
    public void userServiceLog(JoinPoint joinPoint) {
        logger.info("User service : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.blog.service.CommentService.*(..))")
    public void commentServiceLog(JoinPoint joinPoint) {
        logger.info("Comment service : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.solairerove.blog.service.RoleService.*(..))")
    public void roleServiceLog(JoinPoint joinPoint) {
        logger.info("Role service : " + joinPoint.getSignature().getName());
    }
}
