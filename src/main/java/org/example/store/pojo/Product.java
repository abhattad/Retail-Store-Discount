package org.example.store.pojo;

import org.example.store.type.CategoryType;

public class Product {

	private String productName;
	private double productPrice;
	private CategoryType categoryType;
	private double specialDiscount;

	public Product(String productName, double productPrice, CategoryType categoryType) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.categoryType = categoryType;
		this.specialDiscount = 0;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public double getSpecialDiscount() {
		return specialDiscount;
	}

	public void setSpecialDiscount(double specialDiscount) {
		this.specialDiscount = specialDiscount;
	}

	public double totalQuantityPrice(int quantity) {
		return this.productPrice * quantity;
	}

}
