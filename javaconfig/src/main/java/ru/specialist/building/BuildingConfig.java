package ru.specialist.building;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("house.properties")
@ComponentScan("ru.specialist.building")
//@ImportResource("building.xml")
//@EnableTransactionManagement // transaction support (db)
//@EnableWebMvc // web mvc support
public class BuildingConfig {
	
	@Bean // id == brick
	@Scope("prototype")
	public Material brick() {
		return new Brick();
	}
	
	@Bean("mybrick")
	@Scope("prototype")
	public Material bricks2() {
		return new Brick();
	}
	
	/*@Bean("log")
	@Scope("singleton")
	public Material logs() {
		System.out.println("logs()");
		return new Wood();
	}*/
	
	@Bean
	@Scope("prototype")
	public Window woodWindow() {
		return new WoodWindow();
	}	
	
	@Bean
	@Scope("prototype")
	public Window plasticWindow() {
		return new PlasticWindow();
	}
	
	@Bean
	@Scope("prototype")
	public Door woodDoor() {
		return new WoodDoor();
	}
	
	@Bean
	// Scope == singleton
	public Door metalDoor() {
		return new MetalDoor();
	}
	
//	@Value("${house.height}")
//	private int houseHeight;
	
	@Autowired
	private Environment env;
	
	@Bean // id == myHouse
	@Lazy
	public House myHouse( @Value("${house.height}") int houseHeight ) {
		/*logs(); // context.getBean("log", Material.class)
		logs(); // context.getBean("log", Material.class)
		
		House h = new House( 
				logs() // это НЕ ВЫЗОВ МЕТОДА, заменяется на обращение к контейнеру 
					   // context.getBean("log", Material.class)
					   // реализуется с помощью аспектов (AOP)	
				);*/
		
		House h = new House();
		
		h.setHeight(houseHeight);
		
		h.setDoors(new HashMap<String, Door>());
		h.getDoors().put("A", metalDoor());
		
		final int innerDoorCount = env.getProperty("house.innerDoors", Integer.class);
		
		for(int i = 0; i < innerDoorCount; i++)
			h.getDoors().put( String.valueOf((char)('B'+i)), woodDoor());
		
		h.setWindows(new ArrayList<Window>());
		
		final int windowCount = env.getProperty("house.windows", Integer.class, 2);
		for(int i =0 ; i < windowCount; i++)
			h.getWindows().add(woodWindow());
		
		return h;
	}
	
	
	

}
