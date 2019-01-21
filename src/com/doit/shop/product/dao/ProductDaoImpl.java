package com.doit.shop.product.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.doit.shop.constant.DataBasePathConstant;
import com.doit.shop.product.Product;
import com.doit.shop.util.FileOperateUtil;

public class ProductDaoImpl implements ProductDao {

	FileOperateUtil<Product> util = new FileOperateUtil<>();
	
	@Override
	public boolean addProduct(Product p) throws Exception {
		HashMap<String, Product> prodMap = new HashMap<>();
		Product prod = prodMap.put(p.getpId(), p);
		util.writeToDB(DataBasePathConstant.PRODUCT_DATA_PATH, prodMap);
		return true;
	}

	@Override
	public boolean removeProduct(String pId) throws Exception { 
		HashMap<String, Product> prodMap = util.readFromDB(DataBasePathConstant.PRODUCT_DATA_PATH);
		
		Product remove = prodMap.remove(pId);
		util.writeToDB(DataBasePathConstant.PRODUCT_DATA_PATH, prodMap);
		
		return (remove!= null);
	}

	@Override
	public boolean updateProduct(Product p) throws Exception {		
		HashMap<String, Product> prodMap = util.readFromDB(DataBasePathConstant.PRODUCT_DATA_PATH);
		Product put = prodMap.put(p.getpId(), p);
		util.writeToDB(DataBasePathConstant.PRODUCT_DATA_PATH, prodMap);
		if(put!=null){
			return true;
		}
		return false;
	}

	@Override
	public Product getProductById(String pId) throws Exception {
		// TODO Auto-generated method stub
		return util.readFromDB(DataBasePathConstant.PRODUCT_DATA_PATH).get(pId);
	}

	@Override
	public List<Product> getProductsByName(String pName) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Product> prodMap = util.readFromDB(DataBasePathConstant.PRODUCT_DATA_PATH);
		Collection<Product> collection = prodMap.values();
		ArrayList<Product> pList=new ArrayList<>();
		for (Product product : collection) {
			if(product.getpName() == pName){
				pList.add(product);
			}
		}
		return pList;
	}

	@Override
	public List<Product> getProductsByRange(float minPrice, float maxPrice) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Product> prodMap = util.readFromDB(DataBasePathConstant.PRODUCT_DATA_PATH);
		Collection<Product> collection = prodMap.values();
		ArrayList<Product> pList=new ArrayList<>();
		for (Product product : collection) {
			if(product.getPrice() >= minPrice && product.getPrice() <=maxPrice){
				pList.add(product);
			}
		}
		return pList; 
	}

	@Override
	public List<Product> getProductsByCategoryName(String catName) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Product> prodMap = util.readFromDB(DataBasePathConstant.PRODUCT_DATA_PATH);
		Collection<Product> collection = prodMap.values();
		ArrayList<Product> pList=new ArrayList<>();
		for (Product product : collection) {
			if(product.getCategoryName()== catName){
				pList.add(product);
			}
		}
		return pList;
	}

	@Override
	public boolean checkProdcutIfExistById(String pId) throws Exception {
		File file = new File(DataBasePathConstant.PRODUCT_DATA_PATH);
		if(!file.exists()){
			return false;
		}
		
		HashMap<String, Product> prodMap = util.readFromDB(DataBasePathConstant.PRODUCT_DATA_PATH);
		Product product = prodMap.get(pId);
		if(product != null){
			return true;
		}
		
		return false;
	}
	

}
