package ru.specialist.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CourseDao extends
	CrudRepository<Course, Integer>,
	CourseDaoCustomized
	//PagingAndSortingRepository<Course, Integer>
{
	
	@Cacheable("courses")
	Optional<Course> findById(int id);
	
	List<Course> findAll();
	
	// Методы запросов из имени метода
	// префиксы find..By, read...By, query..By, count...By, get...By
	// Distinct, And, Or
	// Optional<Person> getByFirstNameAndLastName(String firstName, String lastName);
	
	// Найти все курсы с указанной длительностью
	List<Course> findByLength(int length);
	

	//@Query(value = "SELECT * FROM Course c WHERE c.length <= ?",
	//			nativeQuery = true) // SQL
	
	// Найти все курсы с длительностью не более указанной
	@Query("SELECT c FROM Course c WHERE c.length <= :mLength") // JPQL
	List<Course> findShortCourses(@Param("mLength") int maxLength);
	
	//@Query("SELECT c FROM Course c WHERE c.length <= ?1") // JPQL
	//List<Course> findShortCourses(int maxLength);	
	
	
	//@Query("SELECT c FROM Course c WHERE c.title LIKE :title") // JPQL
	//List<Course> findByTitle(@Param("title") String title);
	
	// Для методов с заданной длительностью, указать новую длительность 
	@Modifying
	@Query("UPDATE Course c SET c.length = :nLength WHERE c.length = :oLength")
	int changeCourseLength(@Param("oLength") int oldLength, 
			@Param("nLength") int newLength);

}
