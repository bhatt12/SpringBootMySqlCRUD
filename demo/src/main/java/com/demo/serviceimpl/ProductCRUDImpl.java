package com.demo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.Product;
import com.demo.repository.ProductRepository;
import com.demo.service.ProductCRUD;

@Service
public class ProductCRUDImpl implements ProductCRUD{

	@Autowired
	ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> getProduct(Long id) {
		return productRepository.findById(id);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	public Product updateProduct(Long id, Product product) {
		product.setId(id);
		return productRepository.save(product);
	}

}
