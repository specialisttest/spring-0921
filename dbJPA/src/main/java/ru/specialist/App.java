package ru.specialist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDao;
import ru.specialist.dao.DaoConfig;

public class App {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DaoConfig.class))
		{
			CourseDao dao = context.getBean(CourseDao.class);
			
//			dao.delete(3);
//			Course webAsp = dao.findById(7);
//			webAsp.setTitle("Developing web app with ASP.NET Core MVC 9.0");
//			dao.update(webAsp);
//			Course spring = new Course();
//			spring.setTitle("Pattern OOP");
//			spring.setLength(24);
//			spring.setDescription("OOP patterns from GoF");
//			
//			dao.insert(spring);
//			
			
			for(Course course : dao.findAll())
//			for(Course course : dao.findByTitle("web"))
				System.out.println(course);
			
			Course c = dao.findById(4);
			System.out.println(c);
			c.setLength(c.getLength()+1);
			System.out.println(c);
			dao.update(c);
			System.out.println(dao.findById(4));
			
		}


	}

}
