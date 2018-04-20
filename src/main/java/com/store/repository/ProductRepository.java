package com.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.store.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findById(long id);
}