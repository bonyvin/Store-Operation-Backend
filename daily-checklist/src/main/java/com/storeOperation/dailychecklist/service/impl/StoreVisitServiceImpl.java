package com.storeOperation.dailychecklist.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperation.dailychecklist.dto.SubParameterDto;
import com.storeOperation.dailychecklist.entity.MasterStoreVisit;
import com.storeOperation.dailychecklist.entity.StoreVisitParameter;
import com.storeOperation.dailychecklist.entity.StoreVisitSubParameter;
import com.storeOperation.dailychecklist.exception.UserExceptionHandler;
import com.storeOperation.dailychecklist.repository.MasterStoreVisitRepository;
import com.storeOperation.dailychecklist.repository.StoreVisitParameterRepository;
import com.storeOperation.dailychecklist.repository.StoreVisitSubParameterRepository;
import com.storeOperation.dailychecklist.service.StoreVisitService;

@Service
public class StoreVisitServiceImpl implements StoreVisitService{
	
	@Autowired
	private StoreVisitParameterRepository storeVisitRepo;
	
	@Autowired
	private StoreVisitSubParameterRepository storeVisitSubRepo;
	
	@Autowired
	private MasterStoreVisitRepository masterRepo;

	@Override
	public String addParameter(StoreVisitParameter param) {
		
		storeVisitRepo.save(param);
		return "Add parameter sucessfully";	
	
	}

	@Override
	public String addSubParameter(Long paramId, SubParameterDto subParam) {
		// TODO Auto-generated method stub
		StoreVisitParameter parameter = storeVisitRepo.getById(paramId);
		if(parameter == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Store Visit Parameter is no found!");
		}
		
		storeVisitSubRepo.save(new StoreVisitSubParameter(subParam.getDate(), subParam.getSubParameter(), parameter));
		
		return "Added sub Paremeter Sucessfully!";
	}

	@Override
	public String addStoreVisitReport(List<MasterStoreVisit> report) {
		
		for(int i=0;i<report.size();i++) {
			
			List<MasterStoreVisit> reportList = masterRepo.findByVisitNoAndParameterAndSubParameter(report.get(i).getVisitNo(), report.get(i).getParameter(), report.get(i).getSubParameter());
			
			if(reportList.size() != 0) {
				throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Already filled for that visit no! Please retry");
			}
			masterRepo.save(report.get(i));
		}
		
		return "Added sucessfully!";
	}

	@Override
	public List<MasterStoreVisit> getAllStoreVisit(String storeName) {
		List<MasterStoreVisit> detail = new ArrayList<MasterStoreVisit>();
		List<MasterStoreVisit> report = masterRepo.findByStoreName(storeName);
		return report;
	}

	@Override
	public List<MasterStoreVisit> getAllDetailVisit(String visitNo) {
		
		return masterRepo.findByVisitNo(visitNo);
	}

	@Override
	public List<MasterStoreVisit> getAllSubVisitDetail(String visitNo, String parameter) {
		// TODO Auto-generated method stub
		return masterRepo.findByVisitNoAndParameter(visitNo, parameter);
	}

	@Override
	public List<MasterStoreVisit> getYearWiseReport(String storeName, String year, String parameter) {
		return masterRepo.findByYearAndStoreNameAndParameter(year, storeName, parameter);
	}

}
