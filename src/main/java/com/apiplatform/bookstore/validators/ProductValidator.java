package com.apiplatform.bookstore.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.apiplatform.bookstore.models.ProductModel;
import com.apiplatform.bookstore.Errors.Error;

@Component
public class ProductValidator {

	public List<Error> postProductValidator(ProductModel prodductModel) {
		List<Error> errorList = new ArrayList();
		// TODO Auto-generated method stub
		if (prodductModel.getPdName() == null) {
			errorList.add(new Error("pdName","ProductName is null"));
		}
		if (prodductModel.getPdPrice() <= 0) {
			errorList.add(new Error("pdPrice","ProductPrice is zero"));
		}
		if (prodductModel.getPdColor() == null) {
			errorList.add(new Error("pdColor","ProductColor is null"));
		}
		return errorList;
	}

}
