package ru.specialist.building;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("ru.specialist.building")
@PropertySource("house.properties")
@ImportResource("building.xml")
public class BuildingConfig {
	

}
