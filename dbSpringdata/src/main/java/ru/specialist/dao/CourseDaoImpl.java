package ru.specialist.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//SUFFIX: Impl !!! (by default)
//className == Original_repository_interface_name + Impl
public class CourseDaoImpl  implements CourseDaoCustomized{
	
	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public double medianaLength() {
		List<Integer> l = em.createQuery("SELECT c.length FROM Course c ORDER BY c.length", Integer.class)
				.getResultList();
		
		if (l.size() % 2 == 1) return l.get(l.size() / 2);
		else return (l.get(l.size() / 2-1)+l.get(l.size() / 2))/ 2d;
	}

}
