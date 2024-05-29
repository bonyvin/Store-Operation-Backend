package com.storeOperation.productinfomation.Entity;

public class StoreTargetDto {
	
	private int storeTarget;
	
	private int achivedSales;

	public int getStoreTarget() {
		return storeTarget;
	}

	public void setStoreTarget(int storeTarget) {
		this.storeTarget = storeTarget;
	}

	public int getAchivedSales() {
		return achivedSales;
	}

	public void setAchivedSales(int achivedSales) {
		this.achivedSales = achivedSales;
	}

	public StoreTargetDto(int storeTarget, int achivedSales) {
		super();
		this.storeTarget = storeTarget;
		this.achivedSales = achivedSales;
	}

	public StoreTargetDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
