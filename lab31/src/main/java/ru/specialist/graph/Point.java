package ru.specialist.graph;

public class Point extends Shape {
	
	private Coords coords;

	public Point(Coords coords) {
		this.coords = coords;
	}
	
	public int getX() {
		return coords.getX();
	}
	public void setX(int y) {
		coords.setX(y);
	}
	public int getY() {
		return coords.getY();
	}
	public void setY(int y) {
		coords.setY(y);
	}
		
	@Override
	public void draw() {
		System.out.printf("Point %s Color: %s\n", coords, getColor());
		
	}
	
	@Override
	public void erase() {
		System.out.printf("Erase Point at %s\n", coords);
	}

}
