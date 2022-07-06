package com.bbdgrad.blogsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BlogsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogsiteApplication.class, args);
	}
}
