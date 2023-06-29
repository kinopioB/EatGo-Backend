package com.kinopio.eatgo.store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;
import com.kinopio.eatgo.store.service.StoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stores")
public class StoreController {
	
	private final StoreService storeService;
	
	// 삭제 예
	@GetMapping("locations")
	public ResponseEntity<Map<String, List>> getAllStroesLocations() {
		List<StoreDto> list = storeService.getStores();
		Map<String, List> result = new HashMap<>();
		result.put("res", list);
		log.info(list);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	 /**
     * 가게 전체 조회 ( 지도 마커용 ) api
     * @return ResponseEntity<List<StoreSimpleResponseDto>> 
     */
	@GetMapping
	public ResponseEntity<List<StoreSimpleResponseDto>> getAllStores(){
		List<StoreSimpleResponseDto> stores = storeService.getAllStores();
		return new ResponseEntity<List<StoreSimpleResponseDto>> (stores, HttpStatus.OK);
	}
	
	
	 /**
     * 특정 가게 간단 조회 ( 지도용 ) api
     * @return ResponseEntity<StoreResponseDto> 
     */
	@GetMapping("/store/{storeId}")
	public ResponseEntity<StoreResponseDto> getStore(@PathVariable int storeId){
		StoreResponseDto store = storeService.getStore(storeId);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }
	
	/*
	 * 특정 가게 상세 조회 ( 상세 페이지용 ) api
	 * @return ResponseEntity<StoreDetailResponseDto>
	 */
	@GetMapping("/store/detail/{storeId}")
	public ResponseEntity<StoreDetailResponseDto> getStoreDetail(@PathVariable int storeId){
	
		StoreDetailResponseDto storeDetail = storeService.getStoreDetail(storeId);
		return new ResponseEntity<>(storeDetail, HttpStatus.OK);
	}
	
	
	
	@GetMapping("reviews")
	public ResponseEntity<List<ReviewDto>> getAllReviews(){
		List<ReviewDto> reviewListResult = storeService.getAllReviews();
		return new ResponseEntity<List<ReviewDto>>(reviewListResult, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{storeId}/reviews")
	public ResponseEntity<Integer> createReview(@PathVariable int storeId, ReviewDto reviewDto){		
		
		reviewDto.setStoreId(storeId);
 		int result = storeService.createReview(reviewDto); 
		return new ResponseEntity<Integer>(result, HttpStatus.ACCEPTED);
	}
	
	

}
