package com.customer.bill.calculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.customer.bill.discount.slab.CustTypeDiscountSlab;

public class BillCalculatorWithDiscount {
	
	 private static Properties prop;
     
	    static{
	        InputStream is = null;
	        try {
	            prop = new Properties();
	            is = ClassLoader.class.getResourceAsStream("/cust_type.properties");
	            prop.load(is);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    public static String getPropertyValue(String key){
	        return prop.getProperty(key);
	    }    
	    
	
	
	public double calculateBillAfterDiscount(String custTypeStr, double totalBill){
		
		double billAfterDiscount = 0;
		
		String custTypeImplClsStr = getPropertyValue(custTypeStr);
		CustTypeDiscountSlab custTypeDiscountSlab = null;
		try {
			custTypeDiscountSlab = loadCustTypeDiscountSlab(custTypeImplClsStr);
			
			billAfterDiscount =  custTypeDiscountSlab.calculateBillAfterDiscount(totalBill);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw e;
		}
		
		return billAfterDiscount;
	}
	
	
	public static CustTypeDiscountSlab loadCustTypeDiscountSlab( String custTypeImplClsStr ) throws Exception
	{
	    // Load the defined class by the user if it implements our interface
	    if ( CustTypeDiscountSlab.class.isAssignableFrom( Class.forName( custTypeImplClsStr ) ) )
	    {
	        return (CustTypeDiscountSlab) Class.forName( custTypeImplClsStr ).newInstance();
	    }
	    throw new Exception("Class "+custTypeImplClsStr+" does not implement "+CustTypeDiscountSlab.class.getName() );
	}
	
	
	

}
