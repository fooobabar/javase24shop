package com.doit.shop.Test;

import org.junit.Test;

import com.doit.shop.product.Product;
import com.doit.shop.product.dao.ProductDao;
import com.doit.shop.product.dao.ProductDaoImpl;

public class TestProduct {
	@Test
	public void addProductTest() throws Exception{
		Product prod = new Product("p01", "肥皂", 2f, 1000, "日用品","1");
		ProductDao prodDaoImpl = new ProductDaoImpl();
		boolean prodflag = prodDaoImpl.addProduct(prod);
		
	    System.out.println(prodDaoImpl.getProductById(prod.getpId()));
	}
}
