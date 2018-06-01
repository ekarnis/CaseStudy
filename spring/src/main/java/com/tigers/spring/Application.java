package com.tigers.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.tigers")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		
	//addresourcehandler to change location of view pages (from webapp to something else, etc.)
}
