package com.project.fixedasset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootTest
class FixedassetApplicationTests extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FixedassetApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FixedassetApplication.class, args);
	}

}
