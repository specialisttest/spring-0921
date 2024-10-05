package ru.specialist.graph;

public class Circle extends Shape{
	private Coords center;
	private int radius;
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public Circle(Coords center) {
		this(center, 0);
	}
	public Circle(Coords center, int radius) {
		this.center = center;
		setRadius(radius);
	}	
	
	public int getX() {
		return center.getX();
	}
	
	public void setX(int y) {
		center.setX(y);
	}
	public int getY() {
		return center.getY();
	}
	
	public void setY(int y) {
		center.setY(y);
	}	
	
	public void draw() {
		System.out.printf("Circle (%d, %d) Radius: %d Color: %s\n", 
				getX(), getY(), getRadius(), getColor());
		
	}
	
	@Override
	public void erase() {
		System.out.printf("Erase Circle at %s\n", center);
	}
	
}
