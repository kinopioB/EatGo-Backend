package com.kinopio.eatgo.store.dao;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDto;

public interface StoreDao {
	
	List<StoreDto> selectStores();
	List<ReviewDto> selectReviews();
	int insertReview(ReviewDto reviewDto);
	
}
