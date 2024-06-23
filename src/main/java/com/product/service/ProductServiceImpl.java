 package com.product.service;

import java.util.List;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.customexceptionclassdeclaration.ProductIdNotFoundException;
import com.product.model.Product;
import com.product.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired  //This will help to inject object of ProductRepository by the help of spring ioc container
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		
		if(product.getProductName()==null || product.getProductName().isEmpty())
		{
			
			throw new ProductIdNotFoundException();
		}
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId).get();
	}

	@Override
	public String deleteProductById(int productId) {
		// TODO Auto-generated method stub
		Product product =productRepository.findById(productId).get();
		
		if(product!=null){
			productRepository.delete(product);
			return "Deleted Successfully";
		}
		
		return "not found";
		
		
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		try{
			productRepository.deleteAll();
			return "success";
		}
		catch (Exception e) {
			return "There are some problem";
		}
	}

	@Override
	public List<Product> findByName(String name) {
		List<Product> product=productRepository.findByProductName(name);
		return product;
	}

}
