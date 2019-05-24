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
	
	
//	
	
//	private Logger log;
//	@Around("everything()")
//	public Object log(ProceedingJoinPoint pjp) {
//		Object obj = null;
//		log = Logger.getLogger(pjp.getTarget().getClass());
//		log.trace("Method with signature: "+pjp.getSignature());
//		log.trace("with arguments: "+Arrays.toString(pjp.getArgs()));
//		try {
//			obj = pjp.proceed();
//		} catch (Throwable t) {
//			log.error(t.getMessage());
//			for(StackTraceElement s : t.getStackTrace()) {
//				log.warn(s);
//			}
//		}
//		log.info(pjp.getSignature()+" returned: "+obj);
//		return obj;
//	}
//	
//	@Pointcut("execution(* com.revature..*(..))")
//	private void everything() { /* Empty method for hook */ }
}
