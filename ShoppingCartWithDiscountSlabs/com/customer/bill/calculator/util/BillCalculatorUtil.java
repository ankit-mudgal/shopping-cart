package com.customer.bill.calculator.util;

import java.util.List;

import com.customer.bill.discount.slab.vo.DiscountSlab;

public class BillCalculatorUtil {
	
	public static double calculateBillAfterDiscount(double totalBill, List<DiscountSlab> discountSlabs) {

		// TODO Auto-generated method stub
		double discount = 0;
		
		for(DiscountSlab dcs:discountSlabs) {
			
			if(dcs.getUpperLimit() == 0) {
				discount = discount + ((totalBill - dcs.getLowerLimit())*dcs.getDiscount());
				break;
			}
			
			
			if(totalBill <= dcs.getUpperLimit()) {
				discount = discount + ((totalBill - dcs.getLowerLimit())*dcs.getDiscount());
				break;
			}else {
				discount = discount + ((dcs.getUpperLimit() - dcs.getLowerLimit())*dcs.getDiscount());
			}
			
		}
		
		return (totalBill - discount);
	}

}
