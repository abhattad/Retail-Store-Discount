package org.exmaple.store.test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.example.store.checkout.ShoppingCart;
import org.example.store.pojo.Product;
import org.example.store.pojo.User;
import org.example.store.type.CategoryType;
import org.example.store.type.UserType;
import org.junit.Before;
import org.junit.Test;

public class RetailStoreApplicationTest {
	private Product groceryItem;
	private Product otherItem;
	private User employee;
	private User affiliate;
	private User customer;
	private User customerWith2Years;

	@Before
	public void setUp() {
		employee = new User("pratik Joshi", UserType.EMPLOYEE_TYPE);
		affiliate = new User("Amit Bhattad", UserType.AFFILIATE_TYPE);
		customer = new User("Ramesh Varma", UserType.CUSTOMER_TYPE);
		customerWith2Years = new User("Alex", LocalDateTime.of(2016, 7, 19, 6, 40, 45), UserType.CUSTOMER_TYPE);
		groceryItem = new Product("Rice", 20, CategoryType.GROCEORY_ITEM_TYPE);
		otherItem = new Product("TV", 222, CategoryType.OTHER_ITEM_TYPE);
	}

	@Test
	public void test_employeeWithGrocery() {
		ShoppingCart cart = new ShoppingCart(employee);
		cart.add(groceryItem, 4);
		System.out.println(cart.totalBill());
		assertEquals(80.0, cart.totalBill());

	}

	@Test
	public void test_employeeWithOtherItem() {
		ShoppingCart cart = new ShoppingCart(employee);
		cart.add(otherItem, 4);
		System.out.println(cart.totalBill());
		assertEquals(591.6, cart.totalBill());

	}

	@Test
	public void test_affiliateWithGrocery() {
		ShoppingCart cart = new ShoppingCart(affiliate);
		cart.add(groceryItem, 4);
		System.out.println(cart.totalBill());
		assertEquals(80.0, cart.totalBill());

	}

	@Test
	public void test_affiliateWithOtherItem() {
		ShoppingCart cart = new ShoppingCart(affiliate);
		cart.add(otherItem, 4);
		System.out.println(cart.totalBill());
		assertEquals(764.2, cart.totalBill());

	}

	@Test
	public void test_simpleUserWithGrocery() {
		ShoppingCart cart = new ShoppingCart(customer);
		cart.add(groceryItem, 4);
		System.out.println(cart.totalBill());
		assertEquals(80.0, cart.totalBill());

	}

	@Test
	public void test_simpleUserWithOtherItem() {
		ShoppingCart cart = new ShoppingCart(customer);
		cart.add(otherItem, 4);
		System.out.println(cart.totalBill());
		assertEquals(848.0, cart.totalBill());
	}

	@Test
	public void test_simpleUserWith2YearsWithGrocery() {
		ShoppingCart cart = new ShoppingCart(customerWith2Years);
		cart.add(groceryItem, 4);
		System.out.println(cart.totalBill());
		assertEquals(80.0, cart.totalBill());

	}

	@Test
	public void test_simpleUserWith2YearsWithOtherItem() {
		ShoppingCart cart = new ShoppingCart(customerWith2Years);
		cart.add(otherItem, 4);
		System.out.println(cart.totalBill());
		assertEquals(803.6, cart.totalBill());

	}

	@Test
	public void test_employeeWithGroceryAndOtherItem() {
		ShoppingCart cart = new ShoppingCart(employee);
		cart.add(groceryItem, 4);
		cart.add(otherItem, 4);
		System.out.println(cart.totalBill());
		assertEquals(666.6, cart.totalBill());

	}
}