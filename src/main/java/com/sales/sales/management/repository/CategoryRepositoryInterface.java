package com.sales.sales.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Category;

public interface CategoryRepositoryInterface extends JpaRepository<Category,Long>{

	Category findByName(String name);
}
