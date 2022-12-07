package com.maven.spring.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogginAspect {

	@Before("execution(* com.maven.spring.springaop.ProductServiceImpl.multiply(..))")
	public void logBefore(JoinPoint joinpoint) {
		System.out.println("Before Calling the method");
	}

	@After("execution(* com.maven.spring.springaop.ProductServiceImpl.multiply(..))")
	public void logAfter(JoinPoint joinpoint) {
		System.out.println("After Calling the method");
	}

}
