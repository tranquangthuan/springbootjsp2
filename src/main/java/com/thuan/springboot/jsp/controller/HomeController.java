package com.thuan.springboot.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thuan.springboot.jsp.entity.Product;
import com.thuan.springboot.jsp.service.ProductServiceImpl;

@RestController
public class HomeController {
	@Autowired
	private ProductServiceImpl productServiceImpl;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public List<Product> index() {

		List<Product> products = productServiceImpl.getProducts();
		return products;
	}
}
