package com.thuan.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thuan.springboot.jsp.entity.Product;
import com.thuan.springboot.jsp.repository.ProductRepositoty;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepositoty productRepository;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Page<Product> getProductPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return productRepository.findAll(pageable);
	}

	@Override
	public List<Product> search(String name) {
		// TODO Auto-generated method stub
		return productRepository.findByNameContaining(name);
	}

}
