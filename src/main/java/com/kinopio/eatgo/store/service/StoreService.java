package com.kinopio.eatgo.store.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDto;

public interface StoreService {
	
	List<StoreDto> getAllStores();
	List<ReviewDto> getAllReviews();
	int createReview(ReviewDto reviewDto);
	
}
