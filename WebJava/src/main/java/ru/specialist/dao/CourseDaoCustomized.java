package ru.specialist.dao;

import java.util.List;

public interface CourseDaoCustomized {
	List<Course> findByTitle(String title);
}
