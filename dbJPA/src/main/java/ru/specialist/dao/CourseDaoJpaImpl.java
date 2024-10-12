package ru.specialist.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// JPA
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository("courseDao")
public class CourseDaoJpaImpl implements CourseDao {
	
	@PersistenceContext
	private EntityManager em;

	//@Cacheable(value = "coursesCache", key="#parameter_name")
	@Cacheable("coursesCache")
	@Transactional(readOnly = true)
	@Override
	public Course findById(int id) {
		return em.find(Course.class, id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> findAll() {
		return em.createQuery("select c from Course c", // JPQL
				Course.class).getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> findByTitle(String title) {
		return em.createQuery("select c from Course c where c.title LIKE :title", // JPQL
				Course.class)
				.setParameter("title","%"+title+"%")
				.getResultList();
	}

	@Override
	@CachePut(value = "coursesCache"/*, key="#course.id"*/)
	public void insert(Course course) {
		em.persist(course);
		
	}

	@Override
	@CachePut(value = "coursesCache"/*, key="#course.id"*/)
	public void update(Course course) {
		em.merge(course);
	}

	@Override
	@CacheEvict("coursesCache")
	public void delete(int id) {
		em.remove(findById(id));
		
	}

}
