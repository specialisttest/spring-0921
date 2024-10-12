package ru.specialist.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("courseDao")
public class CourseDaoHibernateImpl implements CourseDao{
	
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Value("#{sessionFactory}")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@Override
	public Course findById(int id) {
		return getSessionFactory().getCurrentSession()
				.byId(Course.class).load(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> findAll() {
		return getSessionFactory().getCurrentSession()
				.createSelectionQuery("from Course c", Course.class).list(); // HQL
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> findByTitle(String title) {
		return getSessionFactory().getCurrentSession()
				.createSelectionQuery("from Course c where c.title LIKE :title", Course.class) // HQL
				.setParameter("title", "%"+title+"%")
				.list();
	}

	@Override
	public void insert(Course course) {
//		getSessionFactory().getCurrentSession().save(course);
		getSessionFactory().getCurrentSession().persist(course);
		
	}

	@Override
	public void update(Course course) {
//		getSessionFactory().getCurrentSession().update(course);
		getSessionFactory().getCurrentSession().merge(course);
		
	}

	@Override
	public void delete(int id) {
		Course c = new Course();
		c.setId(id);
		getSessionFactory().getCurrentSession().remove(c);
		
	}

}
