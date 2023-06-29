package com.kinopio.eatgo.store.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

public interface StoreService {
	
	
	List<StoreDto> getStores(); // 삭제 예정 

	List<StoreSimpleResponseDto> getAllStores();

	List<ReviewResponseDto> getAllStoreReviews(int storeId);

	List<StoreSimpleResponseDto> getCategoryStores(int categoryId);

	List<StoreSimpleResponseDto> getTagStores(String tagName);
	

	StoreResponseDto getStore(int storeId);
	
	StoreDetailResponseDto getStoreDetail(int storeId);

	
	List<ReviewDto> getAllReviews();
	
	Boolean createReview(ReviewRequestDto reviewRequestDto);
	
}
