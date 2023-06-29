package com.kinopio.eatgo.store.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

public interface StoreService {
	
	
	List<StoreDto> getStores(); // 삭제 예정 

	List<StoreSimpleResponseDto> getAllStores();
	
	StoreResponseDto getStore(int storeId);
	
	StoreDetailResponseDto getStoreDetail(int storeId);

	
	List<ReviewDto> getAllReviews();
	
	int createReview(ReviewDto reviewDto);


}
