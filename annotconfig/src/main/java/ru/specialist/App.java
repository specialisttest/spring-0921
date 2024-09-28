package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.specialist.building.BuildingConfig;
import ru.specialist.building.House;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(BuildingConfig.class);
				//new AnnotationConfigApplicationContext("ru.specialist.building");
				
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("building.xml");		
		
		House house = context.getBean("myHouse", House.class);
		house.buildWall();
		house.installDoors();
		house.ventilate();

	}
	/*
	 *  @Component – универсальная аннотация, указывающая, что класс
			является компонентом Spring;
		@Controller – указывает, что класс определяет контроллер
			Spring MVC;
		@RestController – указывает, что класс определяет контроллер
			REST сервиса;
		@Repository – указывает, что класс определяет репозиторий дан-
				ных;
		@Service – указывает, что класс определяет службу;
		
		любая пользовательская аннотация, определенная с помощью
				аннотации @Component.
	 * 
	 */	
}
