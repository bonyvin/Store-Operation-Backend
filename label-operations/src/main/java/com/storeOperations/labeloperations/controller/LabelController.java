package com.storeOperations.labeloperations.controller;

import java.time.LocalDateTime;
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

import com.storeOperations.labeloperations.entity.ChangeRequest;
import com.storeOperations.labeloperations.entity.LabelDto;
import com.storeOperations.labeloperations.entity.PriceChangeLabel;
import com.storeOperations.labeloperations.entity.Replenishment;
import com.storeOperations.labeloperations.entity.ReplenishmentDto;
import com.storeOperations.labeloperations.entity.SearchLabelDto;
import com.storeOperations.labeloperations.entity.SelfLabel;
import com.storeOperations.labeloperations.service.Labelservice;
import com.storeOperations.labeloperations.service.impl.LabelServiceImpl;


@RestController
@RequestMapping("/api/label")
public class LabelController {
	
	@Autowired
	private Labelservice labelService;
	
	@PostMapping("/addLabel")
	public ResponseEntity<String> createLabel(@RequestBody LabelDto labelDto){
		String savedapp = labelService.addLabelandProduct(labelDto);
		return new ResponseEntity<>(savedapp,HttpStatus.CREATED);
	}
	
	@GetMapping("/showLabelInfo/{selfLabelId}/{store}")
	public ResponseEntity<LabelDto> showLabel(@PathVariable("selfLabelId") String selfLabelId,@PathVariable("store") String store){
		LabelDto self = labelService.viewItemInSelf(selfLabelId,store);
		return new ResponseEntity<>(self,HttpStatus.OK);
	}
	

	@PostMapping("/addQtyForReplenishment")
	public ResponseEntity<String> addQtyGapscanning(@RequestBody ReplenishmentDto replenishmentDto){
		String savedapp = labelService.replenishmentOrder(replenishmentDto);
		return new ResponseEntity<>(savedapp,HttpStatus.CREATED);
	}
	
	@GetMapping("/showLabels/{store}")
	public ResponseEntity<List<SelfLabel>> showLabels(@PathVariable("store") String store){
		List<SelfLabel> shelf = labelService.selfLabel(store);
		return new ResponseEntity<>(shelf,HttpStatus.OK);
	}
	
	@PostMapping("/addChangeRequest")
	public ResponseEntity<String> addChangeRequest(@RequestBody ChangeRequest changeReq){
		String savedapp = labelService.addChangeRequest(changeReq);
		return new ResponseEntity<>(savedapp,HttpStatus.CREATED);
	}
	
	@GetMapping("/showAllChangeRequest/{store}")
	public ResponseEntity<List<ChangeRequest>> showCahngeRequest(@PathVariable("store") String store){
		List<ChangeRequest> changeReq = labelService.allChangeRequest(store);
		return new ResponseEntity<>(changeReq,HttpStatus.OK);
	}
	
	
	@GetMapping("/showLableInfo/{id}/{store}")
	public ResponseEntity<SearchLabelDto> SerachLabel(@PathVariable("id") String id,  @PathVariable("store") String store){
		SearchLabelDto info = labelService.lableInfo(id, store);
		return new ResponseEntity<>(info,HttpStatus.OK);
	}
	
	
	@GetMapping("/priceChangeLabel/{date}/{store}")
	public ResponseEntity<List<PriceChangeLabel>> labelPriceChange(@PathVariable("date") String date,  @PathVariable("store") String store){
		List<PriceChangeLabel> lableInfo = labelService.detailLabel(date,store);
		return new ResponseEntity<>(lableInfo,HttpStatus.OK);
	}
	
	@GetMapping("/allreplenishment/{storeName}")
	public ResponseEntity<List<Replenishment>> allreplenishment(@PathVariable("storeName") String storeName){
		List<Replenishment> lableInfo = labelService.allReplenishment(storeName);
		return new ResponseEntity<>(lableInfo,HttpStatus.OK);
	}
	
	@GetMapping("/allreplenishment/{date}/{storeName}")
	public ResponseEntity<List<Replenishment>> allreplenishmentbydate(@PathVariable("date") String date,@PathVariable("storeName") String storeName){
		List<Replenishment> lableInfo = labelService.allReplenishmentBydate(date,storeName);
		return new ResponseEntity<>(lableInfo,HttpStatus.OK);
	}
	

	@GetMapping("/allreplenishment/{itemCode}/{storeName}")
	public ResponseEntity<List<Replenishment>> allreplenishmentbyItemCode(@PathVariable("itemCode") String itemCode,@PathVariable("storeName") String storeName){
		List<Replenishment> lableInfo = labelService.allReplenishmentByItemCode(storeName, itemCode);
		return new ResponseEntity<>(lableInfo,HttpStatus.OK);
	}
	
	@GetMapping("/allreplenishment/{reqId}/{storeName}")
	public ResponseEntity<List<Replenishment>> allreplenishmentbyReqId(@PathVariable("reqId") String reqId,@PathVariable("storeName") String storeName){
		List<Replenishment> lableInfo = labelService.allReplenishmentsByRequestId(storeName, reqId);
		return new ResponseEntity<>(lableInfo,HttpStatus.OK);
	}
	
	@GetMapping("/allBydates/{startDate}/{endDate}/{storeName}")
	public ResponseEntity<List<Replenishment>> filterBydateReplishment(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate,@PathVariable("storeName") String storeName){
		List<Replenishment> replishReq = labelService.replishmentbyDates(startDate, endDate, storeName);
		return new ResponseEntity<>(replishReq,HttpStatus.OK);
	}
}
