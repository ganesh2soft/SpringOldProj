package com.aynavil.tourapp.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.databind.ObjectMapper;



@Aspect
@Component
public class LoggingAdvice {

	Logger log=LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Pointcut(value="execution(* com.aynavil.tourapp.controller.TourRestController.*(..))")
	public void myPointCut() {
		
	}
	@Around("myPointCut()")	
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper objMapper=new ObjectMapper();
		String className=pjp.getSignature().getName();
		String methodName=pjp.getTarget().getClass().toString();
		Object[] argarray=pjp.getArgs();
	
		log.info(" ClassName is " +className+ " Method Name is "+methodName+ " ARG are as follows "+objMapper.writeValueAsString(argarray));
		Object resObject=pjp.proceed();
	    log.info(" ClassName is " +className+ " Method Name is "+methodName+ " myresponse are"+ objMapper.writeValueAsString(resObject));
		return resObject;
		
	}
}
