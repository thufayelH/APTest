package com.ap.qa.dataprovider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ap.datamodel.ProductData;
import com.ap.qa.util.DataBuilder;

public class DataProviders {
	//Building a connection between the user and the product to be purchased
	@DataProvider(name= "ProductData")
	public Iterator<Object[]> loginDataProvider (){
		Collection<Object[]> customerData = new ArrayList<Object[]>();
		{
			{
				DataBuilder dataBuilder = new DataBuilder();
				List<ProductData> data = dataBuilder.prepareProductdata();
				for (ProductData customerModel : data) {
				customerData.add(new Object[] { customerModel });
				}
			}
		}
		return customerData.iterator();
	}
	@Test(dataProvider = "ProductData")
	public void testData(ProductData data) {
		System.out.println(data.getProductName());
		System.out.println(data.getQuantity());
		System.out.println(data.getColor());
		System.out.println(data.getSize());
	}
}
	
