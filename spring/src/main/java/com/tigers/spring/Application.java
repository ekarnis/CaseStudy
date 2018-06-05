package com.tigers.spring;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tigers.services.UserService;

@SpringBootApplication
@ComponentScan(basePackages="com.tigers")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		
	//addresourcehandler to change location of view pages (from webapp to something else, etc.)

	@Bean
	public DataSource getDataSource() {
		final String SERVER = "localhost";
		final String PORT = "1521";
		final String USERNAME = "phase2";
		final String PASSWORD = "drew123";
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@" + SERVER + ":" + PORT + ":XE");
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		return dataSource;
	}
	
	@Bean
	public UserService getUserService() {
		return new UserService(getDataSource());
	}
}
