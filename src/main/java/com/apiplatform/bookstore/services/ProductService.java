package com.apiplatform.bookstore.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.apiplatform.bookstore.exceptions.BadRequestException;
import com.apiplatform.bookstore.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiplatform.bookstore.models.ProductModel;
import com.apiplatform.bookstore.respositories.ProductRepository;
import com.apiplatform.bookstore.validators.ProductValidator;
import com.apiplatform.bookstore.Errors.Error;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductValidator productValidator;
	
	public APIResponse getProductsServie() {
		APIResponse apiResponse = new APIResponse();
		Map<String,Object> maps = new HashMap<>();
		maps.put("product",productRepository.findAll());
		apiResponse.setData(maps);
		return apiResponse;
	}

	public Optional<ProductModel> getProductService(String id) {
		return productRepository.findById(id);
	}

	public ProductModel postProductService(ProductModel productModel) {
		List<Error> errors = productValidator.postProductValidator(productModel);
		if (errors.size() > 0) {
			throw new BadRequestException("bad request",errors);
		}
		return productRepository.insert(productModel);
	}

	public ProductModel putProductService(ProductModel productModel, String id) {
		Optional<ProductModel> getProductModel = productRepository.findById(id);
		if (getProductModel.isPresent()) {
			ProductModel _productModel = getProductModel.get();
			_productModel.setPdName(productModel.getPdName());
			_productModel.setPdPrice(productModel.getPdPrice());
			_productModel.setPdColor(productModel.getPdColor());
			return productRepository.save(_productModel);
		} else {
			return null;
		}
	}

	public String deleteProductService(String id) {
		Optional<ProductModel> getProductModel = productRepository.findById(id);
		if (getProductModel.isPresent()) {
			productRepository.deleteById(id);
			return "Delete Product " +id+"Successfully";
		} else {
			return "Somethings Went Worng";
		}
	}
	
}
