package com.storeOperation.dailychecklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeOperation.dailychecklist.entity.MasterStoreVisit;

public interface MasterStoreVisitRepository extends JpaRepository<MasterStoreVisit, Long>{

	List<MasterStoreVisit> findByVisitNoAndParameterAndSubParameter(String visitNo, String parameter,String subParamter);
	
//	List<MasterStoreVisit> findAllDistinctVisitNo();
	
	List<MasterStoreVisit> findByVisitNo(String visitNo);
	
	List<MasterStoreVisit> findByVisitNoAndParameter(String visitNo, String parameter);
	
	List<MasterStoreVisit> findByStoreName(String storeName);
	
	List<MasterStoreVisit> findByYearAndStoreNameAndParameter(String year, String storeName, String parameter);
}
