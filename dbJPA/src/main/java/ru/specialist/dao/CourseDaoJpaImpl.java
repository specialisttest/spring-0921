package ru.specialist.dao;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.transaction.TransactionStatus;

// JPA
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional(isolation = Isolation.READ_COMMITTED,
			timeout = 20, propagation = Propagation.REQUIRED, readOnly = false /* default */)
@Repository("courseDao")
public class CourseDaoJpaImpl implements CourseDao {
	
	@PersistenceContext
	private EntityManager em;
	
	private PlatformTransactionManager tm;
	private TransactionTemplate tt;
	
	@Autowired
	public CourseDaoJpaImpl(PlatformTransactionManager tm) {
		this.tm = tm;
		this.tt = new TransactionTemplate(tm);
	}
	
	public void TestTransaction() {
		this.tt.setIsolationLevel( Isolation.READ_COMMITTED.value() );
		this.tt.setTimeout(10);
		this.tt.executeWithoutResult( new Consumer<TransactionStatus>() {
			@Override
			public void accept(TransactionStatus t) {
				// operations within transaction
				
			}
			
		});
	}
	

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
