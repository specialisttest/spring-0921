package ru.specialist.lab11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		System.out.println("before context creation");
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("persons.xml");
		System.out.println("after context creation");
		
		Person p  = context.getBean(Person.class);
		p.setAge(47);
		Person p2 = context.getBean(Person.class);
		
		System.out.println(p);
		System.out.println(p2);
		System.out.println(p.hashCode());
		System.out.println(p2.hashCode());
		
		System.out.println(p == p2);
		
	}

}
