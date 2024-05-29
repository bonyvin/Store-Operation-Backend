package com.storeOperation.productinfomation.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.storeOperation.productinfomation.Entity.EmployeeTarget;
import com.storeOperation.productinfomation.Entity.ModePaymentDto;
import com.storeOperation.productinfomation.Entity.OrderDto;
import com.storeOperation.productinfomation.Entity.OrderItems;
import com.storeOperation.productinfomation.Entity.Product;
import com.storeOperation.productinfomation.Entity.ProductDetails;
import com.storeOperation.productinfomation.Entity.ProductDisplayInfoDto;
import com.storeOperation.productinfomation.Entity.ProductDisplayPromotion;
import com.storeOperation.productinfomation.Entity.PromotionAddDto;
import com.storeOperation.productinfomation.Entity.PromotionDetailInfo;
import com.storeOperation.productinfomation.Entity.PromotionList;
import com.storeOperation.productinfomation.Entity.SalesReportDto;
import com.storeOperation.productinfomation.Entity.StoreSalesDto;
import com.storeOperation.productinfomation.Entity.StoreTarget;
import com.storeOperation.productinfomation.Entity.StoreTargetDto;

public interface ProductService {
	
	Product addProduct(Product product);
    ProductDetails addProductDetails(Long prodId,ProductDetails prodDetails);
    
    ProductDisplayInfoDto getAllDataBySkuandStore(String sku,String storeName);
    
    List<ProductDetails> getAllStoreStockBySku(String sku);
    
    List<Product> getAllSimilarProduct(String category);
    
    String addPromotion(PromotionList promoList);
    
    String addPromotionItemList(List<PromotionAddDto> promotionItem);
    
    List<PromotionList> listAllPromotions();
    
    PromotionDetailInfo promoDetail(String promoId);
    
    ProductDisplayPromotion promoDetailsOnProduct(String productSku);
    
    List<Product> getAllMatchProduct(String sku);
    
    String addOrdersPlaced(OrderDto orderInfo);
    
    StoreSalesDto salesDetailsYear(String storename,String year);
    
    StoreSalesDto salesDetailsMonthAndYear(String storename,String month,String year);
    
    StoreSalesDto salesDetailsDate(String storename,String date);
    
    ModePaymentDto modeofSalesInYear(String storename,String year);
    
    ModePaymentDto modeofSalesInYearMonth(String storename,String year,String month);
    
    ModePaymentDto modeinCurrentDate(String storename,String date);
    
    List<SalesReportDto> reportMonthWise(String storename,String month,String year);
    
    List<SalesReportDto> reportDateWise(String storename,String date);
    
    List<SalesReportDto> reportByStaffwise(String storename,String name);
    
    List<SalesReportDto> reportStaffMonthandYear(String storename,String name,String month,String year);
    
    List<SalesReportDto> reportSatffDatewise(String storename,String name,String date);
    
//    List<HashMap<String, Integer>> salesofProduct(String storeName,Long prodId,String year);
    
    List<OrderItems> salesofProductMonth(String storeName,Long prodId,String year,String month);
    
    String addStoreTarget(StoreTarget target);
    
    String addEmpTarget(EmployeeTarget target);
    
    StoreTargetDto monthWiseStoreSalesTarget(String storeName,String year,String month);
    
    StoreTargetDto yearWiseStoreSalesTarget(String storeName,String year);
    
    StoreTargetDto monthWiseEmpSalesTarget(String empName,String storeName,String year,String month);
    
    StoreTargetDto yearWiseEmpSalesTarget(String empName,String storeName,String year);

List<SalesReportDto> reportByDateAndTime(LocalDateTime startDate,LocalDateTime endDate,String storename);
    
    List<SalesReportDto> reportByDateAndTimeAndStaff(LocalDateTime startDate,LocalDateTime endDate,String storename,String staffName);
    
}
