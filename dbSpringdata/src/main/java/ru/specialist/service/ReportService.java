package ru.specialist.service;

public interface ReportService {
	
	public static record CourseStatistics(int total, 
			double averageLength, 
			double medianaLength) {}
	
	
	// Total courses: ... Average Length: ... Mediana length: ...
	
	CourseStatistics getCourseStatistics();

}
