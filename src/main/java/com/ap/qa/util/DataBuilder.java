package com.ap.qa.util;

import java.util.ArrayList;
import java.util.List;

import com.ap.datamodel.ProductData;

public class DataBuilder {

	public List<ProductData> prepareProductdata(){
		List<ProductData> productsData1 = new ArrayList<ProductData>();
		Read_XLS read = new Read_XLS("Product.xlsx", "/src/main/resources/testdata/");
		Object[][] objs = new Object[read.retrieveNoOfRows("Sheet") - 1][read.retrieveNoOfCols("Sheet")];
		objs = read.retrieveTestData1("Sheet1");//Read_XLS update pending
		for(Object[] obj : objs) {
			ProductData productData2 = new ProductData();
			productData2.setProductName(obj[0].toString());//ProductData
			productData2.setQuantity(obj[1].toString());//ProductData
			productData2.setSize(obj[2].toString());//ProductData
			productData2.setColor(obj[3].toString());//ProductData
			productsData1.add(productData2);
		}
		return productsData1;
	}

}
