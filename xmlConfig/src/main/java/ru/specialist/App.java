package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.building.*;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		House house = context.getBean(House.class);
		house.buildWall();
		house.ventilate();

	}

}
