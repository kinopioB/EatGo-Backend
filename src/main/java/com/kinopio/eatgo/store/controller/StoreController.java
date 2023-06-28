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
import com.kinopio.eatgo.store.dto.StoreDto;
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
	
	@GetMapping("locations")
	public ResponseEntity<Map<String, List>> getAllStroesLocations() {
		
		List<StoreDto> list = storeService.getAllStores();
		Map<String, List> result = new HashMap<>();
		result.put("res", list);
		log.info(list);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
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
