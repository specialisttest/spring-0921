package ru.specialist.aop;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		//method.getAnnotation(MyAnnotaion.class) != null
		
		return method.getName().contains("write");
	}

}
