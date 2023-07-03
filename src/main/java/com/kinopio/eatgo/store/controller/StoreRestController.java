package com.kinopio.eatgo.store.controller;


import java.util.List;
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
import com.kinopio.eatgo.store.dto.ApiResult;
import com.kinopio.eatgo.store.dto.PopularStoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreHistoryRequestDto;
import com.kinopio.eatgo.store.dto.StoreRequestDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;
import com.kinopio.eatgo.store.dto.TodayOpenStoreResponseDto;
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
	 * 
	 * @return ResponseEntity<List<StoreSimpleResponseDto>>
	 */
	@GetMapping
	public ResponseEntity<List<StoreSimpleResponseDto>> getAllStores() {

		List<StoreSimpleResponseDto> stores = storeService.getAllStores();
		return new ResponseEntity<List<StoreSimpleResponseDto>>(stores, HttpStatus.OK);
	}

	/**
	 * 특정 가게 간단 조회 api
	 * 
	 * @param storeId
	 * @return ResponseEntity<StoreResponseDto>
	 */
	@GetMapping("/{storeId}")
	public ResponseEntity<StoreResponseDto> getStore(@PathVariable int storeId) {
		StoreResponseDto store = storeService.getStore(storeId);
		return new ResponseEntity<>(store, HttpStatus.OK);
	}

	/**
	 * 특정 가게 상세 조회 api
	 * 
	 * @param storeId
	 * @return ResponseEntity<StoreDetailResponseDto>
	 */
	@GetMapping("/detail/{storeId}")
	public ResponseEntity<StoreDetailResponseDto> getStoreDetail(@PathVariable int storeId) {

		StoreDetailResponseDto storeDetail = storeService.getStoreDetail(storeId);
		return new ResponseEntity<>(storeDetail, HttpStatus.OK);
	}

	/**
	 * 가게 등록하기 api
	 * 
	 * @param storeRequestDto
	 * @return ResponseEntity<ApiResult>
	 */
	@PostMapping
	public ResponseEntity<StoreDetailResponseDto> createStore(@RequestBody StoreRequestDto storeRequestDto) {
		return new ResponseEntity<StoreDetailResponseDto>(storeService.createStore(storeRequestDto),HttpStatus.CREATED);
	}

	/**
	 * 영업 시작 등록 api 
	 * @param storeId
	 * @param StoreHistoryRequestDto
	 * @return ResponseEntity<ApiResult>
	 */
	@PostMapping("/{storeId}/open")
	public ResponseEntity<ApiResult> changeStoreStatusOpen(@PathVariable int storeId, @RequestBody StoreHistoryRequestDto storeHistoryRequestDto){
		storeHistoryRequestDto.setStoreId(storeId);
		if(storeService.changeStoreStatusOpen(storeHistoryRequestDto)) {
			return new ResponseEntity<ApiResult>(
					ApiResult.builder().status(ApiResult.STATUS_SUCCESS).message("영업 시작 등록에 성공하였습니다.").build(),
					HttpStatus.CREATED);
		}
		return new ResponseEntity<ApiResult>(
				ApiResult.builder().status(ApiResult.STATUS_FAIL).message("영업 시작 등록에 실패하였습니다.").build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/**
	 * 영업 종료 등록 api 
	 * @param storeId
	 * @return ResponseEntity<ApiResult>
	 */
	@PostMapping("/{storeId}/close")
	public ResponseEntity<ApiResult> changeStoreStatusClose(@PathVariable int storeId){
		if(storeService.changeStoreStatusClose(storeId)) {
			return new ResponseEntity<ApiResult>(
					ApiResult.builder().status(ApiResult.STATUS_SUCCESS).message("영업 종료 등록에 성공하였습니다.").build(),
					HttpStatus.OK);
		}		
		return new ResponseEntity<ApiResult>(
				ApiResult.builder().status(ApiResult.STATUS_FAIL).message("영업 종료 등록에 실패하였습니다.").build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * 특정 가게 리뷰들 조회 api 
	 * @param storeId
	 * @return ResponseEntity<List<ReviewResponseDto>>
	 */
	@GetMapping("/{storeId}/reviews")
	public ResponseEntity<List<ReviewResponseDto>> getAllStoreReviews(@PathVariable int storeId) {

		List<ReviewResponseDto> storeReviewResult = storeService.getAllStoreReviews(storeId);
		return new ResponseEntity<List<ReviewResponseDto>>(storeReviewResult, HttpStatus.OK);
	}

	/**
	 * 리뷰 등록 api 
	 * @param storeId
	 * @param reviewRequestDto
	 * @return ResponseEntity<ApiResult>
	 */
	@PostMapping("/{storeId}/reviews")
	public ResponseEntity<ApiResult> createReview(@PathVariable int storeId,
			@RequestBody ReviewRequestDto reviewRequestDto) {
		reviewRequestDto.setStoreId(storeId);
		Boolean result = storeService.createReview(reviewRequestDto);
		if (result) {
			return new ResponseEntity<ApiResult>(
					ApiResult.builder().status(ApiResult.STATUS_SUCCESS).message("가게 등록에 실패하였습니다.").build(),
					HttpStatus.CREATED);
		}
		return new ResponseEntity<ApiResult>(
				ApiResult.builder().status(ApiResult.STATUS_FAIL).message("리뷰 등록에 실패하였습니다.").build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/** 
	 * 특정 카테고리 해당 가게들 ( 마커용 ) 조회 api
	 * @param categoryId
	 * @return ResponseEntity<List<StoreSimpleResponseDto>> 
	 */
	@GetMapping("/categories/{categoryId}")
	public ResponseEntity<List<StoreSimpleResponseDto>> getCategoryStores(@PathVariable int categoryId) {
		List<StoreSimpleResponseDto> categoryStore = storeService.getCategoryStores(categoryId);
		return new ResponseEntity<List<StoreSimpleResponseDto>>(categoryStore, HttpStatus.OK);
	}

	/**
	 * 특정 태그 포함한 가게들 ( 마커용 ) 조회 api
	 * @param tagName
	 * @return ResponseEntity<List<StoreSimpleResponseDto>>
	 */
	@GetMapping("/tags/{tagName}")
	public ResponseEntity<List<StoreSimpleResponseDto>> getTagStores(@PathVariable String tagName) {
		List<StoreSimpleResponseDto> tagStore = storeService.getTagStores(tagName);
		return new ResponseEntity<List<StoreSimpleResponseDto>>(tagStore, HttpStatus.OK);
	}
	
	/**
	 * 리뷰가 많은 가게 top 10 조회 api
	 * @return  ResponseEntity<List<PopularStoreResponseDto>>
	 */
	@GetMapping("/popular")
	public ResponseEntity<List<PopularStoreResponseDto>> getPopularStores(){
		List<PopularStoreResponseDto> popularStores = storeService.getPopularStores();
		log.info("logs{} ", popularStores);
		return new ResponseEntity<List<PopularStoreResponseDto>>(popularStores, HttpStatus.OK);
	}
	
	/**
	 * 오늘 오픈한 가게 조회 api
	 * @return ResponseEntity<List<TodayOpenStoreResponseDto>> 
	 */
	@GetMapping("/today-open")
	public ResponseEntity<List<TodayOpenStoreResponseDto>> getTodayOpenStores(){
		List<TodayOpenStoreResponseDto> todayOpenStores = storeService.getTodayOpenStores();
		log.info("todayOpenStores Response {} ", todayOpenStores);
		return new ResponseEntity<List<TodayOpenStoreResponseDto>>(todayOpenStores, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	

}
