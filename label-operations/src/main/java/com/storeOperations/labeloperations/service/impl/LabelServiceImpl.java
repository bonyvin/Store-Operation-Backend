package com.storeOperations.labeloperations.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.storeOperations.labeloperations.entity.ChangeRequest;
import com.storeOperations.labeloperations.entity.ItemLabel;
import com.storeOperations.labeloperations.entity.LabelDto;
import com.storeOperations.labeloperations.entity.PriceChangeLabel;
import com.storeOperations.labeloperations.entity.Replenishment;
import com.storeOperations.labeloperations.entity.ReplenishmentDto;
import com.storeOperations.labeloperations.entity.SearchLabelDto;
import com.storeOperations.labeloperations.entity.SelfLabel;
import com.storeOperations.labeloperations.exception.UserExceptionHandler;
import com.storeOperations.labeloperations.repository.ChangeRequestRepository;
import com.storeOperations.labeloperations.repository.ItemLabelRepository;
import com.storeOperations.labeloperations.repository.PriceChangeLabelRepository;
import com.storeOperations.labeloperations.repository.ReplenishmentRepository;
import com.storeOperations.labeloperations.repository.SelfLabelRepository;
import com.storeOperations.labeloperations.service.Labelservice;

import ch.qos.logback.core.read.ListAppender;

@Service
public class LabelServiceImpl implements Labelservice {
	
	@Autowired
	private ItemLabelRepository itemLabelrepo;
	
	@Autowired
	private SelfLabelRepository selfLabelrepo;
	
	@Autowired
	private ReplenishmentRepository replenishmentRepo;
	
	@Autowired
	private ChangeRequestRepository changeRepo;
	
	@Autowired
	private PriceChangeLabelRepository changePriceLabelRepo;

	@Override
	public String addLabelandProduct(LabelDto labeldto) {
		SelfLabel selfLabel = new SelfLabel();
		selfLabel.setSelfLabelId(labeldto.getSelfLabel().getSelfLabelId());
		selfLabel.setSelfLabelName(labeldto.getSelfLabel().getSelfLabelName());
		selfLabel.setSelfLabelImg(labeldto.getSelfLabel().getSelfLabelImg());
		selfLabel.setStoreName(labeldto.getSelfLabel().getStoreName());
		selfLabel.setMaxItem(labeldto.getSelfLabel().getMaxItem());
		selfLabel.setMaxQtyForSingleProduct(labeldto.getSelfLabel().getMaxQtyForSingleProduct());
		
		selfLabelrepo.save(selfLabel);
		
		if(labeldto.getSelfLabel().getMaxItem() < labeldto.getItemList().size()) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Max item range exceed!!");
		}
		
		for(int i=0;i< labeldto.getItemList().size();i++) {
			itemLabelrepo.save(new ItemLabel(labeldto.getItemList().get(i).getItemLabelName(),labeldto.getItemList().get(i).getItemCode(),labeldto.getItemList().get(i).getItemLabelImg(),selfLabel ));
		}
		
		return "Add Item into label sucessfully!!";
	}

	@Override
	public LabelDto viewItemInSelf(String selfLabelId, String storeName) {
		
		SelfLabel label = selfLabelrepo.findBySelfLabelIdAndStoreName(selfLabelId, storeName);
		
		if(label == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No Label id found!!");
		}
		
		List<ItemLabel> itemList = itemLabelrepo.findBySelfLabel(label);
		LabelDto detailLabel = new LabelDto();
		detailLabel.setSelfLabel(label);
		detailLabel.setItemList(itemList);
		
		return detailLabel;
			
		
	}

	@Override
	public String replenishmentOrder(ReplenishmentDto replenishment) {
		
		SelfLabel label = selfLabelrepo.findBySelfLabelIdAndStoreName(replenishment.getSelfLabel(), replenishment.getStoreName());
		if(label == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No Label id found!!");
		}
		
		for(int i =0;i<replenishment.getListItem().size();i++) {
			if(itemLabelrepo.findByItemCode(replenishment.getListItem().get(i).getItemCode()).getSelfLabel().getSelfLabelId() == null || itemLabelrepo.findByItemCode(replenishment.getListItem().get(i).getItemCode()).getSelfLabel().getSelfLabelId() != 
					label.getSelfLabelId()) {
				throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Items code is not aligned with this shelf");
			}
		}
		
	
		for(int i =0;i<replenishment.getListItem().size();i++) {
			
			List<Replenishment> replenishmentList = replenishmentRepo.findByStoreNameAndItemCode(replenishment.getListItem().get(i).getStoreName(),replenishment.getListItem().get(i).getItemCode()).stream().filter(rep -> rep.getStatus().equals("Pending")).collect(Collectors.toList());
			System.out.println(replenishmentList.size());
			
			if(replenishmentList.size() != 0) {
				throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "Last request for "+replenishment.getListItem().get(i).getItemCode()+ "code replishment is pending");
			}
			
			replenishmentRepo.save(new Replenishment(replenishment.getListItem().get(i).getReqId(),replenishment.getListItem().get(i).getItemCode(),replenishment.getListItem().get(i).getCurrentQty(),label.getMaxQtyForSingleProduct(),replenishment.getListItem().get(i).getQtyReplenished(),
					replenishment.getListItem().get(i).getDate(),replenishment.getListItem().get(i).getStoreName(),replenishment.getListItem().get(i).getStatus(),replenishment.getListItem().get(i).getLastupdatedTime(),label));
			
		}
		
		return "Notification sent for replenishment!";
		
		
	}

	@Override
	public List<SelfLabel> selfLabel(String storeName) {
		List<SelfLabel> listLabel = selfLabelrepo.findByStoreName(storeName);
		if(listLabel.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No shelf found!");
		}
		
		return listLabel;
	}

	@Override
	public String addChangeRequest(ChangeRequest changeReq) {
		changeRepo.save(changeReq);
		return "Add change Label request sucessfully!";
	}

	@Override
	public List<ChangeRequest> allChangeRequest(String storeName) {
		List<ChangeRequest> allRequest = changeRepo.findByStoreName(storeName);
		if(allRequest.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No Request found!");
		}
		
		return allRequest;
	}

	@Override
	public SearchLabelDto lableInfo(String id, String storeName) {
		SelfLabel shelf = selfLabelrepo.findBySelfLabelIdAndStoreName(id, storeName);
		ItemLabel iteminfo =   itemLabelrepo.findByItemCode(id);
		SearchLabelDto info = new SearchLabelDto();
		if(shelf != null) {
			List<ItemLabel> itemLabelInfo = itemLabelrepo.findBySelfLabel(shelf);
			info.setItemInfo(null);
			info.setShelfInfo(shelf);
			info.setItemInfoList(itemLabelInfo);
			return info;	
		}
		else if(iteminfo == null) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No Request found!");
		}
		info.setItemInfo(iteminfo);
		info.setItemInfoList(null);
		info.setShelfInfo(null);
		return info;
	}

	@Override
	public List<PriceChangeLabel> detailLabel(String date, String storeName) {
		// TODO Auto-generated method stub
		List<PriceChangeLabel> itemInfo = changePriceLabelRepo.findByDate(date);
		if(itemInfo.size() == 0) {
			throw new UserExceptionHandler(HttpStatus.BAD_REQUEST, "No Request found!");
		}
		return itemInfo;
	}

	@Override
	public List<Replenishment> allReplenishment(String storeName) {
		// TODO Auto-generated method stub
		return replenishmentRepo.findByStoreName(storeName);
	}

	@Override
	public List<Replenishment> allReplenishmentBydate(String date,String storeName) {
		// TODO Auto-generated method stub
		return replenishmentRepo.findByDateAndStoreName(date, storeName);
	}

	@Override
	public List<Replenishment> allReplenishmentByItemCode(String storeName, String itemCode) {
		// TODO Auto-generated method stub
		return replenishmentRepo.findByStoreNameAndItemCode(storeName, itemCode);
	}

	@Override
	public List<Replenishment> allReplenishmentsByRequestId(String storeName, String reqId) {
		// TODO Auto-generated method stub
		return replenishmentRepo.findByStoreNameAndReqId(storeName, reqId);
	}

	@Override
	public List<Replenishment> replishmentbyDates(String startDate, String endDate, String storeName) {
		List<Replenishment> replishmentOrders = replenishmentRepo.findByDateBetween(startDate, endDate);
		List<Replenishment> repFilterOrder = replishmentOrders.stream().filter(order -> order.getStoreName().startsWith(storeName)).collect(Collectors.toList());
		return repFilterOrder;
	}
	
	
	
	

}
