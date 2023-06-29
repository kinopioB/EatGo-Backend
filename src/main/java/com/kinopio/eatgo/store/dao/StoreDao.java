package com.kinopio.eatgo.store.dao;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

public interface StoreDao {
	
	List<StoreDto> selectStores();
	List<StoreSimpleResponseDto> selectAllStore();
	int insertReview(ReviewRequestDto reviewDto) throws Exception;
	List<ReviewResponseDto> selectStoreReviews(int storeId);
	List<StoreSimpleResponseDto> selectCategoryStores(int categoryId);
	List<StoreSimpleResponseDto> selectTagStores(String tagName);
}
