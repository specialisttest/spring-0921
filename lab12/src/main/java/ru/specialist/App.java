package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.graph.*;



public class App {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("graph.xml");
		
//		context.getBean("myPoint", Point.class).draw();
//		context.getBean("myCircle", Circle.class).draw();
		context.getBean(Scene.class).draw();

	}

}
