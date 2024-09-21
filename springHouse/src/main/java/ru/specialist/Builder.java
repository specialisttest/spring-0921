package ru.specialist;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("ru.specialist")
public class Builder{
	
	@Autowired
	private PlasticWindow plasticWindow;
	
	@Autowired
	private WoodWindow woodWindow;	
	
	@Bean
	@Scope("prototype")
	public Window defaultWindow() {
		if (Locale.getDefault().getCountry().equals("RU"))
			return woodWindow;
		else 
			return plasticWindow;
	}
	
	@Bean
	public House myHouse() {
		return new House(defaultWindow()); // di
		
	}

}
