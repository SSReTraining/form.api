package com.ss.retraining.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* com.ss.retraining.controller.*.*(..) )" +
            "execution(* com.ss.retraining.service.*.*(..) )" +
            "execution(* com.ss.retraining.repoitory.*.*(..) )"
    )
    public void loggingPointcut() {
    }

    @AfterThrowing(pointcut = "loggingPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getMessage() != null ? e.getMessage() : "NULL");
    }

    @Around("loggingPointcut()")
    public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        log.info("In class " + joinPoint.getTarget().getClass().toString() +
                " method invoked " + joinPoint.getSignature().getName() +
                " arguments : " + Arrays.toString(joinPoint.getArgs()));
        return result;
    }
}
