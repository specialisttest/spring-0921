package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import ru.specialist.building.*;

public class App {
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BuildingConfig.class 
						/*, AnotherConfig.class*/))
		{
			House house = context.getBean( House.class);
			house.buildWall();
			house.installDoors();
			house.ventilate();
		} // context.close();

	}

}

