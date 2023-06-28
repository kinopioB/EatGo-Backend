package com.kinopio.eatgo.store.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

public interface StoreService {
	
	List<StoreDto> getAllStores();
	List<ReviewDto> getAllReviews();
	int createReview(ReviewDto reviewDto);
	
	List<StoreDto> getStrores(); // 삭제 예정 

	List<StoreSimpleResponseDto> getAllStore();
}
