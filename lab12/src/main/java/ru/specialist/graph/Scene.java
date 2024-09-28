package ru.specialist.graph;

import java.util.List;

public class Scene {
	private List<Shape> objects;

	public List<Shape> getObjects() {
		return objects;
	}

	public void setObjects(List<Shape> objects) {
		this.objects = objects;
	}
	
	
	
	public Scene(List<Shape> objects) {
		this.objects = objects;
	}

	public void draw() {
		for(var o : getObjects())
			o.draw();
	}
}
