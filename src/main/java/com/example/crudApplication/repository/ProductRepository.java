package com.example.crudApplication.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudApplication.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String name);



}
