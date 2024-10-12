package ru.specialist.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CourseDao extends 
	CrudRepository<Course, Integer>,
	CourseDaoCustomized
{
	
	// Методы запросов из имени метода
	// префиксы find..By, read...By, query..By, count...By, get...By
	// Distinct, And, Or
	// Optional<Person> getByFirstNameAndLastName(String firstName, String lastName);
	
	// Найти все курсы с указанной длительностью (length == ?)
	Iterable<Course> findByLength(int length);
	
	// Найти все курсы с длительностью не более указанной ( length <= maxLength)
	@Query("SELECT c FROM Course c WHERE c.length <= :mLength") // JPQL
	Iterable<Course> findShortCourses(@Param("mLength") int maxLength);
	
//	@Query("SELECT c FROM Course c WHERE c.title LIKE CONCAT('%', :title, '%')") // JPQL
//	Iterable<Course> findByTitle(@Param("title") String title);	
	
	@Query("SELECT c FROM Course c WHERE c.title LIKE CONCAT('%', ?1 , '%')") // JPQL
	Iterable<Course> findByTitle(String title);	
	
//	@Query(value = "SELECT * FROM courses WHERE title LIKE ('%' || :title || '%')",
//					nativeQuery = true) // PostgreSQL 
//	@Query(value = "SELECT * FROM courses WHERE title LIKE CONCAT('%', :title, '%')",
//				nativeQuery = true) // SQL
//	Iterable<Course> findByTitle(@Param("title") String title);
	
	// Для методов с заданной длительностью, указать новую длительность 
	@Modifying
	@Query("UPDATE Course c SET c.length = :nLength WHERE c.length = :oLength") // JPQL
	int changeCourseLength(@Param("oLength") int oldLength, 
			@Param("nLength") int newLength);
	
	@Query("SELECT AVG(c.length) FROM Course c")
	double averageLength();
	
}
