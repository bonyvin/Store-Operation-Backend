package com.storeOperation.productinfomation.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.storeOperation.productinfomation.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<Product> createProduct(@RequestBody Product prod){
		Product savedCheckList = productService.addProduct(prod);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@PostMapping("/addProductDetails/{productId}")
	public ResponseEntity<ProductDetails> createProductDetails(@PathVariable("productId")Long productId,@RequestBody ProductDetails prod){
		ProductDetails savedCheckList = productService.addProductDetails(productId,prod);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/getProductDetailsInfo/{sku}/{storeName}")
	public ResponseEntity<ProductDisplayInfoDto> getProductDetailsInfo(@PathVariable("sku")String sku,@PathVariable("storeName") String storeName){
		ProductDisplayInfoDto savedData = productService.getAllDataBySkuandStore(sku,storeName);
		return new ResponseEntity<>(savedData,HttpStatus.OK);
	}
	
	@GetMapping("/products/{sku}")
	public ResponseEntity<List<Product>> getProductDetails(@PathVariable("sku")String sku){
		List<Product> savedData = productService.getAllMatchProduct(sku);
		return new ResponseEntity<>(savedData,HttpStatus.OK);
	}
	
	
	@GetMapping("/getProductStockinStores/{sku}")
	public ResponseEntity<List<ProductDetails>> getProductStockinStores(@PathVariable("sku")String sku){
		List<ProductDetails> savedData = productService.getAllStoreStockBySku(sku);
		return new ResponseEntity<>(savedData,HttpStatus.OK);
	}
	
	@GetMapping("/getsimilarProduct/{category}")
	public ResponseEntity<List<Product>> getSimilarProductByCategory(@PathVariable("category")String cat){
		List<Product> savedData = productService.getAllSimilarProduct(cat);
		return new ResponseEntity<>(savedData,HttpStatus.OK);
	}
	
	
	@PostMapping("/addPromotion")
	public ResponseEntity<String> addPromotions(@RequestBody PromotionList promoList){
		String savedCheckList = productService.addPromotion(promoList);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@PostMapping("/addPromotiontoItem")
	public ResponseEntity<String> addPromotionsToItem(@RequestBody List<PromotionAddDto> promotionItem){
		String savedCheckList = productService.addPromotionItemList(promotionItem);
		return new ResponseEntity<>(savedCheckList,HttpStatus.CREATED);
	}
	
	@GetMapping("/promoList")
	public ResponseEntity<List<PromotionList>> promoList(){
		List<PromotionList> promoList = productService.listAllPromotions();
		return new ResponseEntity<>(promoList,HttpStatus.CREATED);
	}
	
	@GetMapping("/promoListDetail/{promoId}")
	public ResponseEntity<PromotionDetailInfo> promoDetail(@PathVariable("promoId") String promoId){
		PromotionDetailInfo promoList = productService.promoDetail(promoId);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/promoItemDetail/{sku}")
	public ResponseEntity<ProductDisplayPromotion> promoItemDetail(@PathVariable("sku") String sku){
		ProductDisplayPromotion promoList = productService.promoDetailsOnProduct(sku);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@PostMapping("/addOrder")
	public ResponseEntity<String> addOrderItem(@RequestBody OrderDto orderInfo){
		String savedOrder = productService.addOrdersPlaced(orderInfo);
		return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/salesYearWise/{storeName}/{year}")
	public ResponseEntity<StoreSalesDto> salesDataYear(@PathVariable("storeName") String storeName,@PathVariable("year") String year){
		StoreSalesDto promoList = productService.salesDetailsYear(storeName,year);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/monthWise/{storeName}/{year}/{month}")
	public ResponseEntity<StoreSalesDto> monthData(@PathVariable("storeName") String storeName,@PathVariable("year") String year,@PathVariable("month") String month){
		StoreSalesDto promoList = productService.salesDetailsMonthAndYear(storeName,month,year);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/dateWise/{storeName}/{date}")
	public ResponseEntity<StoreSalesDto> monthData(@PathVariable("storeName") String storeName,@PathVariable("date") String date){
		StoreSalesDto promoList = productService.salesDetailsDate(storeName,date);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	
	@GetMapping("/salesYearWise/mode/{storeName}/{year}")
	public ResponseEntity<ModePaymentDto> salesModeDataYear(@PathVariable("storeName") String storeName,@PathVariable("year") String year){
		ModePaymentDto promoList = productService.modeofSalesInYear(storeName,year);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/monthWise/mode/{storeName}/{year}/{month}")
	public ResponseEntity<ModePaymentDto> monthmodeData(@PathVariable("storeName") String storeName,@PathVariable("year") String year,@PathVariable("month") String month){
		ModePaymentDto promoList = productService.modeofSalesInYearMonth(storeName,year,month);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/dateWise/mode/{storeName}/{date}")
	public ResponseEntity<ModePaymentDto> monthmodeData(@PathVariable("storeName") String storeName,@PathVariable("date") String date){
		ModePaymentDto promoList = productService.modeinCurrentDate(storeName,date);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/monthWise/sales/{storeName}/{year}/{month}")
	public ResponseEntity<List<SalesReportDto>> monthSalesData(@PathVariable("storeName") String storeName,@PathVariable("year") String year,@PathVariable("month") String month){
		List<SalesReportDto> promoList = productService.reportMonthWise(storeName,month,year);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/dateWise/sales/{storeName}/{date}")
	public ResponseEntity<List<SalesReportDto>> dateSalesData(@PathVariable("storeName") String storeName,@PathVariable("date") String date){
		List<SalesReportDto> promoList = productService.reportDateWise(storeName,date);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/dateWise/staffsales/{storeName}/{name}/{date}")
	public ResponseEntity<List<SalesReportDto>> dateSalesStaffData(@PathVariable("storeName") String storeName,@PathVariable("name") String name,@PathVariable("date") String date){
		List<SalesReportDto> promoList = productService.reportSatffDatewise(storeName,name,date);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/dateWise/staffsales/{storeName}/{name}/{month}/{year}")
	public ResponseEntity<List<SalesReportDto>> monthSalesStaffData(@PathVariable("storeName") String storeName,@PathVariable("name") String name,@PathVariable("month") String month,@PathVariable("year") String year){
		List<SalesReportDto> promoList = productService.reportStaffMonthandYear(storeName, name, month, year);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/staffsales/{storeName}/{name}")
	public ResponseEntity<List<SalesReportDto>> salesStaffData(@PathVariable("storeName") String storeName,@PathVariable("name") String name){
		List<SalesReportDto> promoList = productService.reportByStaffwise(storeName, name);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/salesofProductMonthwise/{storeName}/{prodId}/{year}/{month}")
	public ResponseEntity<List<OrderItems>> salesofProductMonthwise(@PathVariable("storeName") String storeName,@PathVariable("prodId") Long prodId,@PathVariable("year") String year,@PathVariable("month") String month){
		List<OrderItems> promoList = productService.salesofProductMonth(storeName, prodId, year, month);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@PostMapping("/addStoreTarget")
	public ResponseEntity<String> addStoreTarget(@RequestBody StoreTarget target){
		String savedOrder = productService.addStoreTarget(target);
		return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
	}
	
	@PostMapping("/addEmployeeTarget")
	public ResponseEntity<String> addEmployeeTarget(@RequestBody EmployeeTarget target){
		String savedOrder = productService.addEmpTarget(target);
		return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/storetarget/sales/{storeName}/{year}/{month}")
	public ResponseEntity<StoreTargetDto> storetarget(@PathVariable("storeName") String storeName,@PathVariable("year") String year,@PathVariable("month") String month){
		StoreTargetDto promoList = productService.monthWiseStoreSalesTarget(storeName, year, month);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/storetargetyear/sales/{storeName}/{year}")
	public ResponseEntity<StoreTargetDto> storetargetyear(@PathVariable("storeName") String storeName,@PathVariable("year") String year){
		StoreTargetDto promoList = productService.yearWiseStoreSalesTarget(storeName, year);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/employeetarget/sales/{empName}/{storeName}/{year}/{month}")
	public ResponseEntity<StoreTargetDto> emptarget(@PathVariable("empName") String empName,@PathVariable("storeName") String storeName,@PathVariable("year") String year,@PathVariable("month") String month){
		StoreTargetDto promoList = productService.monthWiseEmpSalesTarget(empName, storeName, year, month);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("/employeetargetyear/sales/{empName}/{storeName}/{year}")
	public ResponseEntity<StoreTargetDto> employeetargetyear(@PathVariable("empName") String empName,@PathVariable("storeName") String storeName,@PathVariable("year") String year){
		StoreTargetDto promoList = productService.yearWiseEmpSalesTarget(empName, storeName, year);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("allSales/{storeName}/{startDateTime}/{endDateTime}")
	public ResponseEntity<List<SalesReportDto>> monthSalesStaffData(@PathVariable("storeName") String storeName,@PathVariable("startDateTime") String startDateTime,@PathVariable("endDateTime") String endDateTime){
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		  LocalDateTime startTime = LocalDateTime.parse(startDateTime, formatter);
		  LocalDateTime endTime = LocalDateTime.parse(endDateTime, formatter);
		List<SalesReportDto> promoList = productService.reportByDateAndTime(startTime, endTime, storeName);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	@GetMapping("allSales/staffwise/{storeName}/{startDateTime}/{endDateTime}/{staffName}")
	public ResponseEntity<List<SalesReportDto>> staffwisesales(@PathVariable("storeName") String storeName,@PathVariable("startDateTime") String startDateTime,@PathVariable("endDateTime") String endDateTime,@PathVariable("staffName") String staffName){
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		  LocalDateTime startTime = LocalDateTime.parse(startDateTime, formatter);
		  LocalDateTime endTime = LocalDateTime.parse(endDateTime, formatter);
		List<SalesReportDto> promoList = productService.reportByDateAndTimeAndStaff(startTime, endTime, storeName,staffName);
		return new ResponseEntity<>(promoList,HttpStatus.OK);
	}
	
	
	
	

}
