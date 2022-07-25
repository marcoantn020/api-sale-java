package com.sales.sales.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.ItemSale;

public interface ItemSaleRespositoryInterface extends JpaRepository<ItemSale, Long> {
	
	@Query("SELECT new entity.ItemSale("
			+ " iv.code, iv.quantity, iv.priceSold, iv.product, iv.sale)"
			+ " FROM ItemSale iv "
			+ " WHERE iv.sale.code = :codeSale"
			)
	List<ItemSale> findBySaleByCode(Long codeSale);
}
