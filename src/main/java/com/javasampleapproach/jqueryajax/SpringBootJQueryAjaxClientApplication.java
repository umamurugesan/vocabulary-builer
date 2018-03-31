package com.javasampleapproach.jqueryajax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class SpringBootJQueryAjaxClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJQueryAjaxClientApplication.class, args);
		System.out.println("hi");
	}
}
