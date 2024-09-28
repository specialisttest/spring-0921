package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.building.*;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		House house = context.getBean("myHouse", House.class);
		house.buildWall();
		house.installDoors();
		house.ventilate();

		House house2 = context.getBean("myHouse2", House.class);
		house2.buildWall();
		house2.installDoors();
		house2.ventilate();
		
		Country usa = context.getBean("usa", Country.class);
		System.out.println(usa.getTitle());
		for(var city : usa.getCities())
			System.out.printf("%-20s %s : %d\n", 
					city.getName(), city.getState(), city.getPopulation());
		
	}

}

/* Scope:
 * 	singleton - только один объект на контейнер
 *  prototype - при каждом запросе контейнера создаётся новый экземпляр бина
 *  https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html
 */

/*
 * Внедрение коллекций
 * 
	Элемент	коллекция	 Назначение
	<list> 				Связывание списка значений, допускаются повторяющиеся
						значения
	<set>				 Связывание множества значений, гарантирует отсутствие
						повторяющихся значений
	<map>				 Связывание коллекций пар имя/значение, где имя и значение
						могут быть значениями любых типов
	<props>				 Связывание коллекций пар имя/значениее, где имя и значение
						должны имеет строковый тип (String) 		 
*/