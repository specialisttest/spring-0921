package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import ru.specialist.graph.*;


@ComponentScan("ru.specialist.graph")
@PropertySource("graph.properties")
public class App {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(App.class);
		
		context.getBean(Scene.class).draw();

	}

}
