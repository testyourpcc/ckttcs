package com.happyshop;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Bean
	@Autowired
	public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan("com.happyshop.entity");
		factoryBean.setDataSource(dataSource);
		Properties props = factoryBean.getHibernateProperties();
		props.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		props.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		props.put("current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}

	@Bean
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
}
