package com.sales.sales.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"entity"})
@EnableJpaRepositories(basePackages = {"com.sales.sales.management.repository"})
@ComponentScan(basePackages = {"com.sales.sales.management.service", "com.sales.sales.management.controller", "exceptions", "dto.categoryDTO","dto.productDTO"})
@SpringBootApplication
public class SalesManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagementApplication.class, args);
	}

}
