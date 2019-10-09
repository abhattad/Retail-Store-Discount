package org.example.store.checkout;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import org.example.store.offer.CommonDiscountOffer;
import org.example.store.offer.DiscountOffer;
import org.example.store.pojo.Product;
import org.example.store.pojo.User;
import org.example.store.type.CategoryType;
import org.example.store.type.UserType;

public class ShoppingCart {

	private User user;
	private DiscountOffer commanDiscount;
	private Map<Product, Integer> inventoryStore = null;

	public ShoppingCart(User user) {
		this.user = user;
		inventoryStore = new HashMap<Product, Integer>();
	}

	public void add(Product product, int quantity) {
		int oldCount = inventoryStore.containsKey(product) ? inventoryStore.get(product) : 0;
		if (UserType.EMPLOYEE_TYPE.equals(user.getUserType())) {
			product.setSpecialDiscount(0.3);
			inventoryStore.put(product, oldCount + quantity);
		} else if (UserType.AFFILIATE_TYPE.equals(user.getUserType())) {
			product.setSpecialDiscount(0.1);
			inventoryStore.put(product, oldCount + quantity);
		} else if (UserType.CUSTOMER_TYPE.equals(user.getUserType())) {
			if (ChronoUnit.YEARS.between(user.getJoiningDate(), LocalDateTime.now()) >= 2) {
				product.setSpecialDiscount(0.05);
				inventoryStore.put(product, oldCount + quantity);
			} else {
				inventoryStore.put(product, oldCount + quantity);
			}
		}
	}

	public double totalProductPrice(Product product, int quantity) {
		double totalPrice = 0;
		if (CategoryType.GROCEORY_ITEM_TYPE.equals(product.getCategoryType())) {
			totalPrice = product.totalQuantityPrice(quantity);
		} else if (CategoryType.OTHER_ITEM_TYPE.equals(product.getCategoryType())) {
			double specialDiscount = product.totalQuantityPrice(quantity) * product.getSpecialDiscount();
			totalPrice = product.totalQuantityPrice(quantity) - specialDiscount;
		}
		return totalPrice;
	}

	public double totalBill() {
		double total_bill = 0;
		double min_amount = 100;
		for (Product product : inventoryStore.keySet()) {
			int quantity = inventoryStore.get(product);
			total_bill += totalProductPrice(product, quantity);
		}
		if (min_amount < total_bill) {
			commanDiscount = new CommonDiscountOffer();
			total_bill = commanDiscount.applyDiscount(total_bill);
		}
		return total_bill;
	}

}
