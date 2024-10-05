package ru.specialist.building;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// javax.annotation
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import ru.specialist.building.Window;

public class House implements BeanNameAware, ApplicationContextAware {
	
	private List<Window> windows;
	private Material wall;
	private int height;
	
	private Map<String, Door> doors; // or List[]
	
	public House() {}
	
	public House(Material wall) {
		this.wall = wall;
	}
	public House(List<Window> windows) {
		this.windows = windows;
	}

	public List<Window> getWindows() {
		return windows;
	}

	public void setWindows(List<Window> windows) {
		this.windows = windows;
	}
	
	// property : wall
	public Material getWall() {
		return wall;
	}

	@Autowired
	@Qualifier("log")
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
		//appContext.getBean...
		
		getWindows().forEach(w->w.open());
	}
	
	public void buildWall() {
		System.out.printf("House name: %s\n", beanName);
		for(int i=1; i <= getHeight(); i++) {
			System.out.printf("Floor %d ", i);
			wall.buildUp();
		}
	}
	
	public void installDoors() {
//		for(var door : getDoors())
//			door.install();
		for(Map.Entry<String, Door> e : doors.entrySet()) {
			System.out.printf("Key : %s. ", e.getKey());
			e.getValue().install();
		}
	}

	public Map<String, Door> getDoors() {
		return doors;
	}

	public void setDoors(Map<String, Door> doors) {
		this.doors = doors;
	}
	
	private String beanName;

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		
	}
	
	private ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
	}
	
	@PostConstruct
	public void onCreate() {
		System.out.println("House built");
	}
	
	//@PreDestroy
	// shutdown и close вызываются автоматически перед уничтожением (даже без @PreDestroy)
	public void shutdown()
	{
		System.out.println("House shutdown method");
	}
	
//	public void close()
//	{
//		System.out.println("House close method");
//	}
	
	@PreDestroy
	public void onDestroy()
	{
		System.out.println("House onDestroy method");
	}
	
	
}
