package com.kinopio.eatgo.store.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

public interface StoreService {
	
	
	List<StoreDto> getStores(); // 삭제 예정 

	List<StoreSimpleResponseDto> getAllStores();
	
	List<ReviewDto> getAllReviews();
	
	Boolean createReview(ReviewDto reviewDto);

	List<ReviewDto> getAllStoreReviews(int storeId);
	
}
