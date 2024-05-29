package com.storeOperation.dailychecklist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storeOperation.dailychecklist.dto.SubParameterDto;
import com.storeOperation.dailychecklist.entity.MasterStoreVisit;
import com.storeOperation.dailychecklist.entity.StartDayChecklist;
import com.storeOperation.dailychecklist.entity.StoreVisitParameter;
import com.storeOperation.dailychecklist.service.StoreVisitService;

@RestController
@RequestMapping("/api/dayChecklist")
public class StoreVisitController {
	
	@Autowired
	private StoreVisitService storeVist;
	
	@PostMapping("/addStoreVisitParam")
	public ResponseEntity<String> addStoreVisitParam(@RequestBody StoreVisitParameter param){
		String savedCheckList = storeVist.addParameter(param);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	

	@PostMapping("/addSubStoreVisitParam/{paramid}")
	public ResponseEntity<String> addSubStoreVisitParam(@PathVariable("paramid") Long paramid,@RequestBody SubParameterDto subParam){
		String savedCheckList = storeVist.addSubParameter(paramid, subParam);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	

	@PostMapping("/addReportVisit")
	public ResponseEntity<String> addVisitReport(@RequestBody List<MasterStoreVisit> report){
		String savedCheckList = storeVist.addStoreVisitReport(report);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/getStoreVisits/{storename}")
	public ResponseEntity<List<MasterStoreVisit>> addSubStoreVisitParam(@PathVariable("storename") String storename){
		List<MasterStoreVisit> savedCheckList = storeVist.getAllStoreVisit(storename);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllDetailVisit/{visitno}")
	public ResponseEntity<List<MasterStoreVisit>> getAllDetailVisit(@PathVariable("visitno") String visitno){
		List<MasterStoreVisit> savedCheckList = storeVist.getAllDetailVisit(visitno);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllSubVisitDetail/{visitno}/{parameter}")
	public ResponseEntity<List<MasterStoreVisit>> getAllSubVisitDetail(@PathVariable("visitno") String visitno,@PathVariable("parameter") String parameter){
		List<MasterStoreVisit> savedCheckList = storeVist.getAllSubVisitDetail(visitno, parameter);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/getYearWiseReport/{storeName}/{parameter}/{year}")
	public ResponseEntity<List<MasterStoreVisit>> getYearWiseReport(@PathVariable("storeName") String storeName,@PathVariable("parameter") String parameter,@PathVariable("year") String year){
		List<MasterStoreVisit> savedCheckList = storeVist.getYearWiseReport(storeName, year, parameter);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	

}
