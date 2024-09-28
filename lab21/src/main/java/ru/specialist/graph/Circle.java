package ru.specialist.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myCircle")
@Scope("prototype")
public class Circle extends Shape{
	private Coords center;
	private int radius;
	
	public int getRadius() {
		return radius;
	}
	
	@Value("${circle.radius}")
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Autowired
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
	
	@Value("${circle.x}")
	public void setX(int y) {
		center.setX(y);
	}
	public int getY() {
		return center.getY();
	}
	
	@Value("${circle.y}")
	public void setY(int y) {
		center.setY(y);
	}	
	
	public void draw() {
		System.out.printf("Circle (%d, %d) Radius: %d Color: %s\n", 
				getX(), getY(), getRadius(), getColor());
		
	}
}
