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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreRequestDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;
import com.kinopio.eatgo.store.service.StoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stores")
public class StoreRestController {

	private final StoreService storeService;

	/**
	 * 전체 가게 간단 조회 (마커용) api
	 * @return ResponseEntity<List<StoreSimpleResponseDto>>
	 */
	@GetMapping
	public ResponseEntity<List<StoreSimpleResponseDto>> getAllStores() {

		List<StoreSimpleResponseDto> stores = storeService.getAllStores();
		return new ResponseEntity<List<StoreSimpleResponseDto>>(stores, HttpStatus.OK);

	}

	/**
	 * 특정 가게 간단 조회 api
	 * @param storeId
	 * @return  ResponseEntity<StoreResponseDto> 
	 */
	@GetMapping("/store/{storeId}")
	public ResponseEntity<StoreResponseDto> getStore(@PathVariable int storeId) {
		StoreResponseDto store = storeService.getStore(storeId);
		log.info(store);
		return new ResponseEntity<>(store, HttpStatus.OK);
	}

	/**
	 * 특정 가게 상세 조회 api
	 * @param storeId
	 * @return ResponseEntity<StoreDetailResponseDto>
	 */
	@GetMapping("/store/detail/{storeId}")
	public ResponseEntity<StoreDetailResponseDto> getStoreDetail(@PathVariable int storeId) {

		StoreDetailResponseDto storeDetail = storeService.getStoreDetail(storeId);
		return new ResponseEntity<>(storeDetail, HttpStatus.OK);
	}

	
	@PostMapping("/store")
	public ResponseEntity<Boolean> createStore(@RequestBody StoreRequestDto storeRequestDto){
		if(storeService.createStore(storeRequestDto)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	 
	}
	
	// 스토어 리뷰 불러오기
	@GetMapping("/{storeId}/reviews")
	public ResponseEntity<List<ReviewResponseDto>> getAllStoreReviews(@PathVariable int storeId) {

		List<ReviewResponseDto> storeReviewResult = storeService.getAllStoreReviews(storeId);
		return new ResponseEntity<List<ReviewResponseDto>>(storeReviewResult, HttpStatus.OK);
	}

	// 리뷰 등록하기
	@PostMapping("/{storeId}/reviews/{userId}")
	public ResponseEntity<Boolean> createReview(@PathVariable int userId, @PathVariable int storeId,
			@RequestBody ReviewRequestDto reviewRequestDto) {

		reviewRequestDto.setStoreId(storeId);
		reviewRequestDto.setUserId(userId);
		log.info("dto {} ", reviewRequestDto);
		Boolean result = storeService.createReview(reviewRequestDto);
		if (result) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 카테고리 검색
	@GetMapping("/categories/{categoryId}")
	public ResponseEntity<List<StoreSimpleResponseDto>> getCategoryStores(@PathVariable int categoryId) {
		List<StoreSimpleResponseDto> categoryStore = storeService.getCategoryStores(categoryId);
		return new ResponseEntity<List<StoreSimpleResponseDto>>(categoryStore, HttpStatus.OK);
	}

	// 태그 검색
	@GetMapping("/tag/{tagName}")
	public ResponseEntity<List<StoreSimpleResponseDto>> getTagStores(@PathVariable String tagName) {

		log.info("태그 이름 {}", tagName);
		List<StoreSimpleResponseDto> tagStore = storeService.getTagStores(tagName);
		return new ResponseEntity<List<StoreSimpleResponseDto>>(tagStore, HttpStatus.OK);
	}

}
