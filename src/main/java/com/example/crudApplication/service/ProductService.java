package com.example.crudApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudApplication.entity.Product;
import com.example.crudApplication.repository.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository repository;
	
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> getproducts(){
		return repository.findAll();
	}
	
	public Product getproductById(Long id){
		return repository.findById(id).orElse(null);
	}
	
	public Product getproductByName(String name){
		return repository.findByName(name);
	}
	
	public String deleteProduct(Long id) {
		 repository.deleteById(id);
		 return "product removed "+id;
	}

	public Product updateProduct(Product product,Long id) {
		Product existingproduct=repository.findById(id).orElse(null);
		
		existingproduct.setName(product.getName());
		existingproduct.setPrice(product.getPrice());
		existingproduct.setQuantity(product.getQuantity());
		return repository.save(existingproduct);
		
	}
}
