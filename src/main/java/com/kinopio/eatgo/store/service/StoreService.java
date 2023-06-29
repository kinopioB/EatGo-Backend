package com.kinopio.eatgo.store.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

public interface StoreService {
	
	
	List<StoreDto> getStores(); // 삭제 예정 

	List<StoreSimpleResponseDto> getAllStores();
		
	Boolean createReview(ReviewRequestDto reviewDto);

	List<ReviewResponseDto> getAllStoreReviews(int storeId);

	List<StoreSimpleResponseDto> getCategoryStores(int categoryId);

	List<StoreSimpleResponseDto> getTagStores(String tagName);
	
}
