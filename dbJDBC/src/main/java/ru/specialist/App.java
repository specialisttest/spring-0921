package ru.specialist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDao;
import ru.specialist.dao.CourseDaoConfig;

public class App {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CourseDaoConfig.class))
		{
			CourseDao dao = context.getBean(CourseDao.class);
			
//			dao.delete(2);
//			Course webAsp = dao.findById(7);
//			webAsp.setTitle("Developing web app with ASP.NET Core MVC");
//			dao.update(webAsp);
			Course spring = new Course();
			spring.setTitle("Spring. Base");
			spring.setLength(40);
			spring.setDescription("Intro Spring framework");
			
			dao.insert(spring);
			
			
			for(Course course : dao.findAll())
				System.out.println(course);
			
			//System.out.println(dao.findById(2));
			
		}


	}

}
