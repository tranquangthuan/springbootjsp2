package com.thuan.springboot.jsp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thuan.springboot.jsp.entity.Product;
import com.thuan.springboot.jsp.service.ProductServiceImpl;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	private int pageSize = 3;

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping()
	public String getAll(Model model, @RequestParam(defaultValue = "1") Integer page) {

		// List<Product> products = productServiceImpl.getProducts();
		Page<Product> productPagination = productServiceImpl.getProductPagination(page - 1, pageSize);

		model.addAttribute("products", productPagination.toList());
		model.addAttribute("totalPages", productPagination.getTotalPages());
		model.addAttribute("currentPage", page);

		return "products";
	}

	@GetMapping(value = "/search")
	public String search(Model model, @RequestParam(defaultValue = "") String keySearch) {
		List<Product> products = productServiceImpl.search(keySearch);
		model.addAttribute("products", products);
		// model.addAttribute("keySearch", keySearch);

		return "products";
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable long id) {
		System.out.println("id = " + id);

		Optional<Product> editProduct = productServiceImpl.findById(id);
		if (editProduct.isPresent()) {
			model.addAttribute("product", editProduct.get());
			return "newProduct";
		}
		model.addAttribute("message", "Product not exist");
		List<Product> products = productServiceImpl.getProducts();
		model.addAttribute("products", products);

		return "products";
	}

	@PostMapping(value = "/save")
	public String update(@ModelAttribute("product") @Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct";
		}
		productServiceImpl.save(product);
		return "redirect:/product";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.GET)
	public String addNew(Model model) {
		model.addAttribute("product", new Product());
		return "newProduct";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable long id) {
		System.out.println("id = " + id);
		productServiceImpl.deleteById(id);

		return "redirect:/product";
	}
}
