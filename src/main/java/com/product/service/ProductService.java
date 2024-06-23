package com.product.service;

import java.util.List;

import com.product.model.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(int productId);
	
	public String deleteProductById(int productId);
	
	public String deleteAll();

	public List<Product> findByName(String name);
}
