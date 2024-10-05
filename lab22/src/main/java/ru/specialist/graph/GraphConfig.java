package ru.specialist.graph;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("graph.properties")
@ComponentScan("ru.specialist.graph")
public class GraphConfig {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private Coords coords;
	
	// определил бин coords аннотацией Commponent
//	@Bean
//	@Scope("prototype")
//	public Coords coords() {
//		return new Coords(); 
//	}

	@Bean
	@Scope("prototype")
	public Point myPoint(){
		//Point p = new Point(coords());
		Point p = new Point(coords);
		p.setX(env.getProperty("point.x", Integer.class, 0));
		p.setY(env.getProperty("point.y", Integer.class, 0));
		p.setColor(env.getProperty("point.color", Shape.DEFAULT_COLOR));
		
		return p;
	}

	@Bean
	@Scope("prototype")
	public Circle myCircle(){
		Circle c = new Circle (coords, 
				env.getProperty("circle.radius", Integer.class, 0));
		c.setX(env.getProperty("circle.x", Integer.class, 0));
		c.setY(env.getProperty("circle.y", Integer.class, 0));
		c.setColor(env.getProperty("circle.color", Shape.DEFAULT_COLOR));
		
		return c;
	}
	
//	@Autowired
//	List<Shape> objects;
	
//	@Bean
//	public Scene scene() {
//		return new Scene(objects);
//	}

	
	@Bean
	public Scene scene() {
		List<Shape> objects = new ArrayList<Shape>();
		int pointNums = env.getProperty("scene.points", Integer.class, 1);
		for(int i=0; i < pointNums; i++)
			objects.add(myPoint());
		int circleNums = env.getProperty("scene.circles", Integer.class, 1);
		for(int i=0; i < circleNums; i++)
			objects.add(myCircle());
		
		return new Scene(objects);
	}	

}
