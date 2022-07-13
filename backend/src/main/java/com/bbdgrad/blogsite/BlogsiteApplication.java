package com.bbdgrad.blogsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class BlogsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogsiteApplication.class, args);
	}
}
