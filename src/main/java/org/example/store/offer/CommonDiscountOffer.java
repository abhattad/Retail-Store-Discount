package org.example.store.offer;

public class CommonDiscountOffer implements DiscountOffer {

	public double applyDiscount(double totalAmount) {

		if (totalAmount >= 100) {
			int discountFactor = (int) totalAmount / 100;
			double discount = discountFactor * 5;
			return totalAmount - discount;
		}
		return totalAmount;
	}

}
