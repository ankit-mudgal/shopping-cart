package com.customer.bill.discount.slab.impl;

import java.util.ArrayList;

import com.customer.bill.calculator.util.BillCalculatorUtil;
import com.customer.bill.discount.slab.CustTypeDiscountSlab;
import com.customer.bill.discount.slab.vo.DiscountSlab;

public class RegularDiscountSlab implements CustTypeDiscountSlab {

	private static ArrayList<DiscountSlab> regularDiscountSlabs;
	
	static {
		regularDiscountSlabs = new ArrayList<DiscountSlab>();
		DiscountSlab discountSlab1 = new DiscountSlab();
		discountSlab1.setLowerLimit(0);
		discountSlab1.setUpperLimit(5000);
		discountSlab1.setDiscount(0);
		regularDiscountSlabs.add(discountSlab1);
		DiscountSlab discountSlab2 = new DiscountSlab();
		discountSlab2.setLowerLimit(5000);
		discountSlab2.setUpperLimit(10000);
		discountSlab2.setDiscount(0.1);
		regularDiscountSlabs.add(discountSlab2);
		DiscountSlab discountSlab3 = new DiscountSlab();
		discountSlab3.setLowerLimit(10000);
		discountSlab3.setUpperLimit(0);
		discountSlab3.setDiscount(0.2);
		regularDiscountSlabs.add(discountSlab3);
	}
	
	@Override
	public double calculateBillAfterDiscount(double totalBill) {
		return BillCalculatorUtil.calculateBillAfterDiscount(totalBill, regularDiscountSlabs);
	}

}
