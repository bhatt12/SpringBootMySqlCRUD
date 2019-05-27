package com.demo.service;

import java.util.Optional;

import com.demo.Entity.Product;

/***
 * 
 * @author PBhatt
 *
 */
public interface ProductCRUD {

	/***
	 * Create Product Row
	 */
	public Product addProduct(Product product);
	
	/***
	 * Gets Product detail by Id
	 */
	public Optional<Product>  getProduct(Long id);
	
	/***
	 * Gets Product detail by Id
	 */
	public void deleteProduct(Long id);
	
	/***
	 * Updates Product detail by Id
	 */
	public Product updateProduct(Long id, Product product);
	
	
}
