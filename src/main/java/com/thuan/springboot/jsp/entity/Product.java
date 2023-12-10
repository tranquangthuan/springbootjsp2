package com.thuan.springboot.jsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", columnDefinition = "nvarchar(500)", nullable = false)
	@NotBlank(message = "Vui lòng nhập product name ")
	private String name;

	@Column(name = "color", columnDefinition = "nvarchar(100)", nullable = false)
	@NotBlank(message = "Vui lòng nhập product color ")
	private String color;

	@NotNull(message = "Vui lòng nhập quantity")
	@Range(min = 0, max = 1000, message = "Vui lòng nhập số lượng từ 0 - 1000")
	private Integer quantity;

	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", color=" + color + ", quantity=" + quantity + "]";
	}

}
