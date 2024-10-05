package ru.specialist.graph;

public abstract class Shape {
	
	public static final String DEFAULT_COLOR = "black";
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Shape() {
		this(DEFAULT_COLOR);
	}
	
	public Shape(String color) {
		this.color = color;
	}
	
	public abstract void draw();
	public abstract void erase();

}
