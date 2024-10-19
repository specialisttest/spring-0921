package ru.specialist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.specialist.dao.CourseDao;
import ru.specialist.dao.Course;

//@Controller
@RestController // @Controller + @ResponseBody on every method  
@RequestMapping("api/course")
public class CourseApiController {
	
	@Autowired
	private CourseDao dao; 
	
	@RequestMapping(method = RequestMethod.GET) //  api/course GET
	//@ResponseBody
	public List<Course> list() {
		return dao.findAll();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET) // api/course/5 GET
	//@ResponseBody
	public Course findById(@PathVariable("id") int id) {
		return dao.findById(id).orElseThrow( ()-> new RuntimeException("Course not found"));
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST) // api/course/
	//@ResponseBody
	public Course create(@RequestBody Course course) {
		return dao.save(course);
	}
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	//@ResponseBody
	public Course update(@RequestBody Course course, @PathVariable("id") int id) {
		course.setId(id);
		return dao.save(course);
	}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	//@ResponseBody
	public void delete(@PathVariable("id") int id) {
		dao.deleteById(id);
	}

}
