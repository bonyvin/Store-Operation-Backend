package com.storeOperation.productinfomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.productinfomation.Entity.EmployeeTarget;

public interface EmployeeTargetRepository extends JpaRepository<EmployeeTarget, Long> {
	
	EmployeeTarget findByEmployeeNameAndStoreNameAndMonthAndYear(String emp,String storeName,String month,String year);
	
	List<EmployeeTarget> findByEmployeeNameAndStoreNameAndYear(String emp,String storeName,String year);
	

}
