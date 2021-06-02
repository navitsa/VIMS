package com.navitsa.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages= {"com.navitsa.repository","com.navitsa.hrm.repository"})
public class JpaConfig {
    @Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
    	LocalEntityManagerFactoryBean factoryBeen=new LocalEntityManagerFactoryBean();
    	factoryBeen.setPersistenceUnitName("SalesDB");
    	return factoryBeen;
		
	}
    
    @Bean(name="transactionManager")
    public JpaTransactionManager tranctionManager(EntityManagerFactory entityManagerFactory) {
    	JpaTransactionManager tranctionManager=new JpaTransactionManager();
    	tranctionManager.setEntityManagerFactory(entityManagerFactory);
    	return tranctionManager; 
    }
    
    
	
}
