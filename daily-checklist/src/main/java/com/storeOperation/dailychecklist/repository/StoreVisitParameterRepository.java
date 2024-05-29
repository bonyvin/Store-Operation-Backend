package com.storeOperation.dailychecklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.StoreVisitParameter;

public interface StoreVisitParameterRepository extends JpaRepository<StoreVisitParameter, Long> {
	
	StoreVisitParameter findByParameters(String param);

}
