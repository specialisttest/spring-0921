package ru.specialist;

import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.specialist.dao.Course;
import ru.specialist.dao.CourseDao;
import ru.specialist.dao.DaoConfig;
import ru.specialist.dao.TeacherDao;
import ru.specialist.service.ReportConfig;
import ru.specialist.service.ReportService;

import static java.lang.System.out;

public class App {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DaoConfig.class, ReportConfig.class))
		{
			CourseDao dao = context.getBean(CourseDao.class);
//			Course git = new Course();
//			git.setTitle("GIT");
//			git.setLength(16);
//			git.setDescription("Git Intro");
//			
//			dao.save(git);	
//			dao.findById(12).ifPresent( c->{
//				c.setLength(24);
//				dao.save(c);
//			});
			
			//dao.deleteById(10);
			
			dao.changeCourseLength(40, 48);
			
//			for(Course course : dao.findAll())
//			for(Course course : dao.findByLength(40))
			for(Course course : dao.findByTitle("сервер"))
//			for(Course course : dao.findShortCourses(30))
				System.out.println(course);
//			
			Optional<Course> c = dao.findById(44);
			c.ifPresentOrElse( out::println, ()->out.println("Курс не найден"));
			
			out.printf("Average course length: %.2f\n", dao.averageLength());
			out.printf("Mediana course length: %.2f\n", dao.medianaLength());
			
//			System.out.println(dao.findById(4));
			
			out.println( context.getBean(ReportService.class).getCourseStatistics() );
			
			var tr = context.getBean(TeacherDao.class);
			
			for(var t : tr.findByName("Иван"))
//			for(var t : tr.findAll())
				System.out.printf("%d %s %s %s\n", t.getId(), t.getName(),
						t.getAddress(), t.getPhone());
			
		}


	}

}
