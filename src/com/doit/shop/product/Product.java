package com.doit.shop.product;

import java.io.Serializable;

public class Product implements Serializable{
	private String pId;
	private String pName;
	private float price;
	private int stockNum;
	private String categoryName;
	
	private String status;  // 0：下架 1：上架 2：已被删除

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStockNum() {
		return stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product() {
	}

	public Product(String pId, String pName, float price, int stockNum, String categoryName, String status) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.stockNum = stockNum;
		this.categoryName = categoryName;
		this.status = status;
	}
	public void set(String pId, String pName, float price, int stockNum, String categoryName, String status) {
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.stockNum = stockNum;
		this.categoryName = categoryName;
		this.status = status;
	}

	@Override
	public String toString() {
		return "[pId=" + pId + ", pName=" + pName + ", price=" + price + ", stockNum=" + stockNum
				+ ", categoryName=" + categoryName + ", status=" + status + "]";
	}
	
	
}
