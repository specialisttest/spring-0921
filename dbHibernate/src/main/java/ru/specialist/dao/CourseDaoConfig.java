package ru.specialist.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("jdbc.properties")
@ComponentScan("ru.specialist.dao")
@EnableTransactionManagement
public class CourseDaoConfig {

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
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(webDataSource());
		sf.setPackagesToScan("ru.specialist.dao");
		return sf; 
	}
	
	@Bean
	public TransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactory().getObject());
	}
	

}
