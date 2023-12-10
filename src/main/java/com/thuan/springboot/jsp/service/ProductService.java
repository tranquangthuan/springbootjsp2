package com.thuan.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.thuan.springboot.jsp.entity.Product;

public interface ProductService {

	Product save(Product product);

	List<Product> getProducts();

	List<Product> search(String name);

	Page<Product> getProductPagination(int page, int size);

	void deleteById(long id);

	Optional<Product> findById(long id);

}
