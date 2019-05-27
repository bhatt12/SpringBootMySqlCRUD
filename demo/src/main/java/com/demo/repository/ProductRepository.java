package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	//add other methods here
}
