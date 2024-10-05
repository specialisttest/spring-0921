package ru.specialist.graph;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Scene {
	private List<Shape> objects;

	public List<Shape> getObjects() {
		return objects;
	}

	public void setObjects(List<Shape> objects) {
		this.objects = objects;
	}
	
	
//	@Autowired
	public Scene(List<Shape> objects) {
		this.objects = objects;
	}

	public void draw() {
		for(var o : getObjects())
			o.draw();
	}
	
	//@PreDestroy
	public void erase()
	{
		for(var o : getObjects())
			o.erase();
	}
}
