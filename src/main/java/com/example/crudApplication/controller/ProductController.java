package com.example.crudApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudApplication.entity.Product;
import com.example.crudApplication.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	private ProductService service;
	
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		 return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		 return service.saveProducts(products);
	}
	
	
	@GetMapping("/products")
	public List<Product> FindAllProducts(){
		return service.getproducts();
	}
	
	@GetMapping("/productid/{id}")
	public Product FindProductbyId(@PathVariable Long id) {
		return service.getproductById(id);  
	}
	
	@GetMapping("/productnam/{name}")
	public Product FindProductbyName(@PathVariable String name) {
		return service.getproductByName(name);
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable Long id) {
		return service.updateProduct(product,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteByid(@PathVariable Long id) {
		return service.deleteProduct(id);
	}
}
