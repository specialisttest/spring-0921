package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.building.*;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(BuildingConfig.class
						/*, AnotherConfig.class*/);
		
		House house = context.getBean("myHouse", House.class);
		house.buildWall();
		house.installDoors();
		house.ventilate();

	}

}

