package ru.specialist.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.cglib.proxy.MethodInterceptor;

public class MessageDecorator implements
MethodBeforeAdvice
//AfterReturningAdvice
//MethodInterceptor
//ThrowsAdvice
{
	/*
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.printf("INFO: execute method %s for object %s\n",
				invocation.getMethod().getName(), invocation.getThis());
		System.out.print("Hello ");
		
		//if (...)
		{
			Object retVal = invocation.proceed();
		}
		
		//Object retVal = null;
		System.out.println("!");
		//System.out.println("Миру МИР!");
		
		System.out.printf("INFO: succefully execute method %s for object %s with return: %s\n",
				invocation.getMethod().getName(), invocation.getThis(), retVal);
		
		return retVal;
	}*/

	/*@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("INFO: succefully execute method %s for object %s with return: %s\n",
				method.getName(), target, returnValue);
	}*/	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.print("Hello ");
		//System.out.printf("INFO: execute method %s for object %s\n",
		//		method.getName(), target);
		//if (method.getName().contains("write"))
		//	throw new RuntimeException("Can't call write method");		
	}

}
