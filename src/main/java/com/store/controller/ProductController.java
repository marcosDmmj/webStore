package com.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Product;
import com.store.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@GetMapping(value="/product",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAll() {
		List<Product> list = new ArrayList<>();
		Iterable<Product> products = repository.findAll();

		products.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/postproduct")
	public Product postProduct(@RequestBody Product product) {

		repository.save(new Product(product.getId(), product.getName(), product.getQuantity(), product.getPrice()));
		return product;
	}

	@GetMapping(value="/findbyid/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findById(@PathVariable long id) {

		List<Product> products = repository.findById(id);
		return products;
	}
	
	@DeleteMapping(value="/product/{id}")
	public void deleteProduct(@PathVariable long id){
		
		repository.delete(id);
	}
}
