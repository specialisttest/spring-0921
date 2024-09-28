package ru.specialist.building;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
// javax. ....
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

@Component("myHouse")
@Lazy
//@Scope("singleton") // by default
public class House {
	
	private List<Window> windows;
	private Material wall;
	private int height;
	
	private Map<String, Door> doors; // or List[]
	
	public House() {
		System.out.println("ctor House()");
		
	}
	
	//@Autowired // constructor params by type
	public House(/*@Value("#{brick}")*/ Material wall) {
		this.wall = wall;
	}
	public House(List<Window> windows) {
		this.windows = windows;
	}

	public List<Window> getWindows() {
		return windows;
	}

	@Autowired
	public void setWindows(@Value("#{ {woodWindow, woodWindow, woodWindow} }") List<Window> windows) {
		this.windows = windows;
	}
	
	// property : wall
	public Material getWall() {
		return wall;
	}

	
	//@Autowired(required = false) // by type
	//@Qualifier("logs")
	//@WoodQualifier // value == "Sergey"
	//@WoodQualifier("Andrey")
	//@Value("#{brick}")
	
	//@Inject // @Autowired
	//@Named("logs")
	@Resource(name = "brick")
	public void setWall(Material wall) {
		this.wall = wall;
	}

	public int getHeight() {
		return height;
	}

	@Value("${house.height}") // use SpEL !!!
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public void ventilate() {
		getWindows().forEach(w->w.open());
	}
	
	public void buildWall() {
		for(int i=1; i <= getHeight(); i++) {
			System.out.printf("Floor %d ", i);
			wall.buildUp();
		}
	}
	
	public void installDoors() {
//		for(var door : getDoors())
//			door.install();
		for(Map.Entry<String, Door> e : doors.entrySet()) {
			System.out.printf("Key : %s. ", e.getKey());
			e.getValue().install();
		}
	}

	public Map<String, Door> getDoors() {
		return doors;
	}

	@Value("#{${house.doors}}")
	//@Value("#{ {'A':metalDoor, 'B':woodDoor}  }")
	public void setDoors(Map<String, Door> doors) {
		this.doors = doors;
	}
	
	
}
