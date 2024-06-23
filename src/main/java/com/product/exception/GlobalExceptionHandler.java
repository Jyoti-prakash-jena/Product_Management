package com.product.exception;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.product.customexceptionclassdeclaration.NoProductFoundException;
import com.product.customexceptionclassdeclaration.ProductIdNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ProductIdNotFoundException.class)
	public String productIdNotFoundException(ProductIdNotFoundException pf, Model model) {
		
		ErrorMessage errorMessage = new ErrorMessage("You have not provided Name of the product",new Date(),HttpStatus.BAD_GATEWAY.value());
		
		model.addAttribute("errorMessage", errorMessage);
		
		return "errorpage";
		
	}
	
	
	@ExceptionHandler(NoProductFoundException.class)
	public String noProductFoundException(NoProductFoundException pf, Model model) {
		
		ErrorMessage errorMessage = new ErrorMessage("No such Product found",new Date(),HttpStatus.BAD_GATEWAY.value());
		
		model.addAttribute("errorMessage", errorMessage);
		
		return "errorpage";
		
	}

}
