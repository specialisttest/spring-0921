package ru.specialist.building;

import java.util.List;
import java.util.Map;

import ru.specialist.building.Window;

public class House {
	
	private List<Window> windows;
	private Material wall;
	private int height;
	
	private Map<String, Door> doors; // or List[]
	
	public House() {}
	
	public House(List<Window> windows) {
		this.windows = windows;
	}

	public List<Window> getWindows() {
		return windows;
	}

	public void setWindows(List<Window> windows) {
		this.windows = windows;
	}
	
	public Material getWall() {
		return wall;
	}

	public void setWall(Material wall) {
		this.wall = wall;
	}

	public int getHeight() {
		return height;
	}

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

	public void setDoors(Map<String, Door> doors) {
		this.doors = doors;
	}
	
	
}
