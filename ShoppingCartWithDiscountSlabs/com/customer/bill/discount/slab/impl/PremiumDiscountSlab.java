package com.customer.bill.discount.slab.impl;

import java.util.ArrayList;

import com.customer.bill.calculator.util.BillCalculatorUtil;
import com.customer.bill.discount.slab.CustTypeDiscountSlab;
import com.customer.bill.discount.slab.vo.DiscountSlab;

public class PremiumDiscountSlab implements CustTypeDiscountSlab {
	
	private static ArrayList<DiscountSlab> premiumDiscountSlabs;

static {
	premiumDiscountSlabs = new ArrayList<DiscountSlab>();
	DiscountSlab discountSlab1 = new DiscountSlab();
	discountSlab1.setLowerLimit(0);
	discountSlab1.setUpperLimit(4000);
	discountSlab1.setDiscount(0.1);
	premiumDiscountSlabs.add(discountSlab1);
	DiscountSlab discountSlab2 = new DiscountSlab();
	discountSlab2.setLowerLimit(4000);
	discountSlab2.setUpperLimit(8000);
	discountSlab2.setDiscount(0.15);
	premiumDiscountSlabs.add(discountSlab2);
	DiscountSlab discountSlab3 = new DiscountSlab();
	discountSlab3.setLowerLimit(8000);
	discountSlab3.setUpperLimit(12000);
	discountSlab3.setDiscount(0.2);
	premiumDiscountSlabs.add(discountSlab3);
	DiscountSlab discountSlab4 = new DiscountSlab();
	discountSlab4.setLowerLimit(12000);
	discountSlab4.setUpperLimit(0);
	discountSlab4.setDiscount(0.3);
	premiumDiscountSlabs.add(discountSlab4);
}

@Override
public double calculateBillAfterDiscount(double totalBill) {
	return BillCalculatorUtil.calculateBillAfterDiscount(totalBill, premiumDiscountSlabs);
}
}
