package ru.specialist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.specialist.dao.CourseDao;

@Service("reports")
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public CourseStatistics getCourseStatistics() {
		return new CourseStatistics( 
				(int)courseDao.count(), 
				courseDao.averageLength(),
				courseDao.medianaLength());
	}

}
