package com.doit.shop.product.service;

import java.util.List;

import com.doit.shop.product.Product;

public interface ProductService {
	public List<Product> getProducts();
	public List<Process> getProductsByCategory(String catName);
	public List<Process> getProductsByPriceRange(float minPrice,float maxPrice);
	public Product getProductById(String pId);
	public boolean addProduct(Product p);
	public boolean updateProductName(String pId,String newName);
	public boolean updateProductPrice(String pId,float newPrice);
	public boolean updateProductStockNum(String pId,int newNum);
	public boolean updateProductCategory(String pId,String newCatName);
	public boolean updateProductStatus(String pId,String newStatus);
	
	
	
}
