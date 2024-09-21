package ru.specialist.building;

import ru.specialist.building.Window;

public class House {
	
	private Window window;
	private Material wall;
	private int height;
	
//	public House() {}
	
	public House(Window window) {
		this.window = window;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
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
		getWindow().open();
	}
	
	public void buildWall() {
		for(int i=1; i <= getHeight(); i++) {
			System.out.printf("Floor %d ", i);
			wall.buildUp();
		}
	}
}
