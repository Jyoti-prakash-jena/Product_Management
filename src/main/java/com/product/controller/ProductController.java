package com.product.controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.customexceptionclassdeclaration.NoProductFoundException;
import com.product.customexceptionclassdeclaration.ProductIdNotFoundException;
import com.product.model.Product;
import com.product.service.ProductService;

import ch.qos.logback.core.model.Model;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("/")
	public String showAllData(org.springframework.ui.Model model) {
		
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("listProduct", productList);
		return "index";
	}
	@GetMapping("/showNewProductForm")
	public String newProductForm(org.springframework.ui.Model model) {
		model.addAttribute("productObject",new Product());
		return "new_product";
		
	}
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute Product productObject) {
		
		
		productService.saveProduct(productObject);
		
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String updateProduct(@PathVariable int id,org.springframework.ui.Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		
		return "update_product";
	}
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteProductById(id);
		
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("/showSearchProduct")
	public String showSearchPage() {
		
		
		return "searchproduct";
	}
	
	@GetMapping("/searchResult")
	public String showSearchResult(@RequestParam("productName") String productName, org.springframework.ui.Model model) {
		
		List<Product> products = productService.findByName(productName);
		
		if(products.isEmpty()) {
			
			System.out.println("hello my name is jyotiprakash jena");
			
			throw new NoProductFoundException();
			
			
		}
		model.addAttribute("product", products);
		
		return "searchresult";
		
	}
}
	
