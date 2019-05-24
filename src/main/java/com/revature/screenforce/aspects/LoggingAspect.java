package com.revature.screenforce.aspects;

import java.util.Arrays;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	
	@AfterThrowing(pointcut = "execution(* com.revature.screenforce..*(..)))", throwing = "t")
    public void logAfterThrow(JoinPoint jp, Throwable t) {
        Logger log = LogManager.getLogger(jp.getTarget().getClass());
        log.error(jp.getSignature() + " threw " + t.getClass() + " with stack trace " + t.getStackTrace());
    }
    @AfterReturning(pointcut = "execution(* com.revature.screenforce..*(..))")
    public void logAfter(JoinPoint jp) {
        Logger log = LogManager.getLogger(jp.getTarget().getClass());
        log.info("Method with signature: "+jp.getSignature());
        log.info("With arguments: "+Arrays.toString(jp.getArgs()));
    }
	
	
}
