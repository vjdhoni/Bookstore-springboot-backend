package com.apiplatform.bookstore.respositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apiplatform.bookstore.models.ProductModel;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel,String> {

}
