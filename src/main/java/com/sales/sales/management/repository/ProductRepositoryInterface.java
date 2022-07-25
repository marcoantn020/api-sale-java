package com.sales.sales.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.Product;

public interface ProductRepositoryInterface extends JpaRepository<Product, Long>{

	List<Product> findByCategoryCode(Long codeCategory);
	
	Optional<Product> findByCategoryCodeAndCode(Long codeCategory, Long codeProduct);
	
	Optional<Product> findByCategoryCodeAndDescription(Long codeCategory, String description);
}
