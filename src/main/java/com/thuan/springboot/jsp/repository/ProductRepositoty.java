package com.thuan.springboot.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuan.springboot.jsp.entity.Product;

public interface ProductRepositoty extends JpaRepository<Product, Long> {
	List<Product> findByNameContaining(String name);
}
