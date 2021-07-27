package com.didorg.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAdvice {

    Logger logger = LoggerFactory.getLogger(ExecutionTimeAdvice.class);

    // This is our advice
    @Around("@annotation(com.didorg.aop.aspect.LogExecutionTime)") // point cut argument
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Method " + joinPoint.getSignature() + " >>> EXECUTED IN: " + (endTime - startTime) + " ms");
        return obj;
    }
}
