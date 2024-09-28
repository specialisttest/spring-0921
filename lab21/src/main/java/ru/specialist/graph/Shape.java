package ru.specialist.graph;

import org.springframework.beans.factory.annotation.Value;

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

}
