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
		house.installDoors();
		house.ventilate();

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