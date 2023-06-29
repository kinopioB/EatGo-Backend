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

	// 삭제 예
	@GetMapping("locations")
	public ResponseEntity<Map<String, List>> getAllStroesLocations() {

		List<StoreDto> list = storeService.getStores();
		Map<String, List> result = new HashMap<>();
		result.put("res", list);
		log.info(list);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<List<StoreSimpleResponseDto>> getAllStores() {

		List<StoreSimpleResponseDto> stores = storeService.getAllStores();
		return new ResponseEntity<List<StoreSimpleResponseDto>>(stores, HttpStatus.OK);
	}

	// 마이 페이지 리뷰 불러오기
	@GetMapping("/reviews")
	public ResponseEntity<List<ReviewDto>> getAllReviews() {

		List<ReviewDto> reviewsResult = storeService.getAllReviews();
		if (reviewsResult.isEmpty()) {
			return new ResponseEntity<List<ReviewDto>>(reviewsResult, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ReviewDto>>(reviewsResult, HttpStatus.OK);
	}

	// 스토어 리뷰 불러오기
	@GetMapping("/{storeId}/reviews")
	public ResponseEntity<List<ReviewDto>> getAllStoreReviews(@PathVariable int storeId) {

		List<ReviewDto> storeReviewResult = storeService.getAllStoreReviews(storeId);
		if (storeReviewResult.isEmpty()) {
			return new ResponseEntity<List<ReviewDto>>(storeReviewResult, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ReviewDto>>(storeReviewResult, HttpStatus.OK);
	}

	// 리뷰 등록하기
	@PostMapping("/{userId}/reviews")
	public ResponseEntity<Boolean> createReview(@PathVariable int userId, ReviewDto reviewDto) {

		reviewDto.setUserId(userId);
		Boolean result = storeService.createReview(reviewDto);
		if (result) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
