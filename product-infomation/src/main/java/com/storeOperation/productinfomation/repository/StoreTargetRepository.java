package com.storeOperation.productinfomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.productinfomation.Entity.StoreTarget;

public interface StoreTargetRepository extends JpaRepository<StoreTarget, Long>{

	StoreTarget findByStoreNameAndYearAndMonth(String storeName,String year,String month);
	
	List<StoreTarget> findByStoreNameAndYear(String storeName,String year);
}
