package ru.specialist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.validation.BindingResult;

import ru.specialist.dao.CourseDao;
import ru.specialist.dao.Course;

@Controller
@RequestMapping("/courses/")
public class CourseController {
	@Autowired
	private CourseDao dao;
	//private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET) // /courses/ GET
	public String list(Model uiModel) {
		List<Course> courses = dao.findAll();
		uiModel.addAttribute ("courses", courses);
		return "courses/list";
	}
	
	// /courses/delete/5
	
	@RequestMapping(value = "delete/{id}",method = RequestMethod.GET) // /courses/delete/5
	public String delete(@PathVariable("id") int id, Model uiModel) {
		dao.deleteById(id);
		return "redirect:/courses/";
	}
	
	@RequestMapping(value = "update/{id}",method = RequestMethod.GET) // /courses/update/2
	public String updateForm(@PathVariable("id") int id, Model uiModel) {
		Optional<Course> course = dao.findById(id);
		uiModel.addAttribute ("course", course.orElse(new Course()));
		return "courses/edit";
	}
	@RequestMapping(value = "update/0",method = RequestMethod.GET)
	public String newForm( Model uiModel) {
		return "courses/edit";
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public String update(Course course, BindingResult bindingResult,
				Model uiModel/*, HttpServletRequest httpServletRequest,
				RedirectAttributes redirectAttributes*/) {
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("course", course);
			uiModel.addAttribute("error", "Invalid data");
			return "courses/edit";
		}
		dao.save(course);
		return "redirect:/courses/";
	}

}
