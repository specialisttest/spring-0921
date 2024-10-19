package ru.specialist.dao;

public interface CourseDaoCustomized {
	
	public static record AverageMediana(double average, double mediana) {}
	
	double medianaLength();
	
	// double averageLength();
	
	AverageMediana getAverageAndMedianaLength();

}
