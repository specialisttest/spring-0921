package ru.specialist.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("jdbc.properties")
@ComponentScan("ru.specialist.dao")
@EnableTransactionManagement
@EnableCaching
public class DaoConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource webDataSource() {
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		ds.setUrl(env.getRequiredProperty("jdbc.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.password"));		
		
		return ds;
	}	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(webDataSource());
		
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("ru.specialist.dao");
		
		return emf;
	}
	

	@Bean
	public TransactionManager transactionManager() {
		return new JpaTransactionManager(emf().getObject());
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public CacheManager cacheManager() {
		/*SimpleCacheManager c = new SimpleCacheManager();
		List<Cache> caches = new ArrayList<Cache>();
		caches.add(new ConcurrentMapCache("coursesCache"));
		caches.add(new ConcurrentMapCache("teacherCache"));
		c.setCaches(caches);
		return c;*/
		return new ConcurrentMapCacheManager("coursesCache"/*, "coursesCache"*/);
	}
	

}
