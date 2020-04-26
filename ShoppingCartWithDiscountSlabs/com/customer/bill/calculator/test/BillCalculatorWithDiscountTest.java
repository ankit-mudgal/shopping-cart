package com.customer.bill.calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.customer.bill.calculator.BillCalculatorWithDiscount;

class BillCalculatorWithDiscountTest {

	@Test
	void testRegular5000() {
		BillCalculatorWithDiscount bCWithDisc = new BillCalculatorWithDiscount();
		
		assertEquals(5000, bCWithDisc.calculateBillAfterDiscount("regular", 5000));
	}
	
	@Test
	void testRegular10000() {
		BillCalculatorWithDiscount bCWithDisc = new BillCalculatorWithDiscount();
		
		assertEquals(9500, bCWithDisc.calculateBillAfterDiscount("regular", 10000));
	}

	@Test
	void testRegular15000() {
		BillCalculatorWithDiscount bCWithDisc = new BillCalculatorWithDiscount();
		
		assertEquals(13500, bCWithDisc.calculateBillAfterDiscount("regular", 15000));
	}
	
	@Test
	void testPremium4000() {
		BillCalculatorWithDiscount bCWithDisc = new BillCalculatorWithDiscount();
		assertEquals(3600, bCWithDisc.calculateBillAfterDiscount("premium", 4000));
	}
	
	@Test
	void testPremium8000() {
		BillCalculatorWithDiscount bCWithDisc = new BillCalculatorWithDiscount();
		
		assertEquals(7000, bCWithDisc.calculateBillAfterDiscount("premium", 8000));
	}

	@Test
	void testPremium12000() {
		BillCalculatorWithDiscount bCWithDisc = new BillCalculatorWithDiscount();
		
		assertEquals(10200, bCWithDisc.calculateBillAfterDiscount("premium", 12000));
	}
	
	@Test
	void testPremium20000() {
		BillCalculatorWithDiscount bCWithDisc = new BillCalculatorWithDiscount();
		
		assertEquals(15800, bCWithDisc.calculateBillAfterDiscount("premium", 20000));
	}
	
	
}
