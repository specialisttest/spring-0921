package ru.specialist.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myPoint")
@Scope("prototype")
public class Point extends Shape {
	
	private Coords coords;

	@Autowired
	public Point(Coords coords) {
		this.coords = coords;
	}
	
	public int getX() {
		return coords.getX();
	}
	@Value("${point.x}")
	public void setX(int y) {
		coords.setX(y);
	}
	public int getY() {
		return coords.getY();
	}
	@Value("${point.y}")
	public void setY(int y) {
		coords.setY(y);
	}
		
	@Override
	public void draw() {
		System.out.printf("Point %s Color: %s\n", coords, getColor());
		
	}
	
	@Value("${point.color}")
	@Override
	public void setColor(String color) {
		super.setColor(color);
	}
	

}
