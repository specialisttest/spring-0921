package ru.specialist.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//SUFFIX: Impl !!! (by default)
//className == Original_repository_interface_name + Impl
public class CourseDaoImpl implements CourseDaoCustomized {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Course> findByTitle(String title) {
		return em.createQuery("SELECT c FROM Course c WHERE c.title LIKE :search", Course.class)
				.setParameter("search", "%" + title.trim() + "%")
				.getResultList();
	}

}
