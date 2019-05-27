package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.Product;
import com.demo.service.ProductCRUD;

@RestController
@RequestMapping("/demo/products")

public class ProductController {

	@Autowired
	private ProductCRUD productCRUD;
	
	@PostMapping("/create")
	public ResponseEntity addProduct(@RequestBody Product product)  {
		
		return ResponseEntity.ok(productCRUD.addProduct(product));
		
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id)  {
		
		Optional<Product> product = productCRUD.getProduct(id);
		if (!product.isPresent()) {
        //do logging
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        Product prod = product.get();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "file:///C:/Users/pbhatt/Desktop/productUI/productCRUDForm.html?productName=&productPrice=");
        headers.add("type", "no-cors");
        return ResponseEntity.ok().headers(headers).body(prod);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
		
		Optional<Product> productOldVersion = productCRUD.getProduct(id);
		if(!productOldVersion.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
	    ResponseEntity.ok(productCRUD.updateProduct(id, product));
	    return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {
		
		Optional<Product> product = productCRUD.getProduct(id);
		if(!product.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		productCRUD.deleteProduct(id);
		return ResponseEntity.badRequest().build();
	}
}
