package ru.specialist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//SUFFIX: Impl !!! (by default)
//className == Original_repository_interface_name + Impl
public class CourseDaoImpl  implements CourseDaoCustomized{
	
	@PersistenceContext
	private EntityManager em;

	@Transactional(isolation = Isolation.READ_COMMITTED, 
			propagation = Propagation.REQUIRED, readOnly =  true)
	@Override
	public double medianaLength() {
		List<Integer> l = em.createQuery("SELECT c.length FROM Course c ORDER BY c.length", Integer.class)
				.getResultList();
		
		if (l.size() % 2 == 1) return l.get(l.size() / 2);
		else return (l.get(l.size() / 2-1)+l.get(l.size() / 2))/ 2d;
	}
	
	/*
	@Autowired
	private CourseDao dao;

	//@Transactional(isolation = Isolation.READ_UNCOMMITTED, // если не принципиальна точность ("грязные" данные, разный набор для среднего и медиана)
	@Transactional(isolation = Isolation.SERIALIZABLE, // если хотим чтобы среднее и медиана посчитались по одному набору 
			propagation = Propagation.REQUIRED, readOnly =  true)
	@Override
	public AverageMediana getAverageAndMedianaLength() {
		return  new AverageMediana (dao.averageLength(), dao.medianaLength());
	}*/
	
	@Transactional(isolation = Isolation.READ_COMMITTED, 
			propagation = Propagation.REQUIRED, readOnly =  true)
	@Override
	public AverageMediana getAverageAndMedianaLength() {
		List<Integer> l = em.createQuery("SELECT c.length FROM Course c ORDER BY c.length", Integer.class)
				.getResultList();
		
		double mediana;
		if (l.size() % 2 == 1) mediana = l.get(l.size() / 2);
		else mediana =  (l.get(l.size() / 2-1)+l.get(l.size() / 2))/ 2d;
		
		double average = l.stream().mapToInt(c->c).average().orElse(0.0);
		
		return new AverageMediana(average, mediana);
	}

}
