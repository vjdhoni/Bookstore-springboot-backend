package com.apiplatform.bookstore.controllers;

import java.util.List;
import java.util.Optional;

import com.apiplatform.bookstore.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiplatform.bookstore.models.ProductModel;
import com.apiplatform.bookstore.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/")
	public APIResponse getProducts() {
		return productService.getProductsServie();
	}
	
	@GetMapping(value="/{id}")
	public Optional<ProductModel> getProduct(@RequestParam String id) {
		return productService.getProductService(id);
	}
	
	@PostMapping(value="/new")
	public ProductModel postProduct(@RequestBody ProductModel productModel ) {
		return productService.postProductService(productModel);
	}

	@PutMapping(value="/update/{id}")
	public ProductModel putProduct(@RequestBody ProductModel productModel,@PathVariable String id) {
		return productService.putProductService(productModel,id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable String id) {
		return productService.deleteProductService(id);
	}
}
