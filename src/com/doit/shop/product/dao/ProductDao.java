package com.doit.shop.product.dao;

import java.util.List;

import com.doit.shop.product.Product;

public interface ProductDao {
	public boolean addProduct(Product p) throws Exception;
	public boolean removeProduct(String pId) throws Exception;
	public boolean updateProduct(Product p) throws Exception;
	public Product getProductById(String pId) throws Exception;
	public List<Product> getProductsByName(String pName) throws Exception;
	public List<Product> getProductsByRange(float minPrice,float maxPrice) throws Exception;
	public List<Product> getProductsByCategoryName(String catName) throws Exception;
	public boolean checkProdcutIfExistById(String pId) throws Exception;
	
}
