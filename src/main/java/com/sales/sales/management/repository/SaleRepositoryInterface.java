package com.sales.sales.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Sale;

public interface SaleRepositoryInterface extends JpaRepository<Sale, Long> {
	
	List<Sale> findByClientCode(Long codeClient);
}
