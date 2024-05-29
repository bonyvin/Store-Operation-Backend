package com.storeOperation.dailychecklist.service;

import java.util.List;

import com.storeOperation.dailychecklist.dto.SubParameterDto;
import com.storeOperation.dailychecklist.entity.MasterStoreVisit;
import com.storeOperation.dailychecklist.entity.StoreVisitParameter;

public interface StoreVisitService {
	
	String addParameter(StoreVisitParameter param);
	
	String addSubParameter(Long paramId,SubParameterDto subParam);
	
	String addStoreVisitReport(List<MasterStoreVisit> report);
	
	List<MasterStoreVisit> getAllStoreVisit(String storeName);
	
	List<MasterStoreVisit> getAllDetailVisit(String visitNo);
	
	List<MasterStoreVisit> getAllSubVisitDetail(String visitNo, String parameter);
	
	List<MasterStoreVisit>  getYearWiseReport(String storeName,String year,String parameter);

}
