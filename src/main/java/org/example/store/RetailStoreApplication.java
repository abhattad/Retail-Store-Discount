package org.example.store;

import org.example.store.checkout.ShoppingCart;
import org.example.store.pojo.Product;
import org.example.store.pojo.User;
import org.example.store.type.CategoryType;
import org.example.store.type.UserType;

public class RetailStoreApplication {

	public static void main(String[] args) {

		User employee = new User("Pratik Joshi", UserType.EMPLOYEE_TYPE);
		Product groceryItem = new Product("Rice", 20, CategoryType.GROCEORY_ITEM_TYPE);
		Product otherItem = new Product("TV", 222, CategoryType.OTHER_ITEM_TYPE);

		ShoppingCart cart = new ShoppingCart(employee);
		cart.add(groceryItem, 4);
		cart.add(otherItem, 4);
		System.out.println(cart.totalBill());

	}

}
