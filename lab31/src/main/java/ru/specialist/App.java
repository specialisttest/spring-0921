package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.graph.*;



public class App {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(GraphConfig.class))
		{
			context.getBean(Scene.class).draw();
		} // context.close()
		
		

	}

}
