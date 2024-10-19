package ru.specialist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"ru.specialist.controllers", 
		"ru.specialist.models", "ru.specialist.dao", "ru.specialist.services"})
@EnableWebMvc
@PropertySource("/WEB-INF/dao/jdbc.properties")
@PropertySource("/WEB-INF/dao/hibernate.properties")
@EnableTransactionManagement
@EnableCaching
@EnableJpaRepositories(basePackages = "ru.specialist.dao")
public class ApplicationConfig {
	@Bean("restTemplate")
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource webDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		
		return ds;
	}	
	
	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean emf() {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(webDataSource());
		
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("ru.specialist.dao");
		
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(emf().getObject());
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public CacheManager cacheManager() {

		return new ConcurrentMapCacheManager("courses");
		
	}

}
