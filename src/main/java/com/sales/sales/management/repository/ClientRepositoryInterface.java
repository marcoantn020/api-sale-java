package com.sales.sales.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Client;

public interface ClientRepositoryInterface extends JpaRepository<Client, Long>{
	
	Client findByName(String name);

}
