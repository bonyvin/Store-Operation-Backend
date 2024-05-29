package com.storeOperations.labeloperations.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperations.labeloperations.entity.Replenishment;

public interface ReplenishmentRepository extends JpaRepository<Replenishment, Long> {
	
	List<Replenishment> findByDateAndStoreName(String date,String storeName);
	
	List<Replenishment> findByStoreName(String storeName);
	
	List<Replenishment> findByStoreNameAndItemCode(String storeName,String itemCode);
	
	List<Replenishment> findByStoreNameAndReqId(String storeName,String reqId);
	
	List<Replenishment>  findByDateBetween(String startDate,String endDate);

}
