//package com.bezkoder.spring.jdbc.mysql;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.core.env.Environment;
//
//@Configuration
//@PropertySource("classpath:database.properties")
//public class MvcConfiguration implements WebMvcConfigurer {
//
//	private final String URL = "url";
//	private final String USER = "dbuser";
//	private final String DRIVER = "driver";
//	private final String PASSWORD = "dbpassword";
//    
//    @Autowired
//	Environment environment;
//
//    @Bean
//	DataSource dataSource() {
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setUrl(environment.getProperty(URL));
//		driverManagerDataSource.setUsername(environment.getProperty(USER));
//		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
//		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
//		return driverManagerDataSource;
//	}
//
// 
//}



