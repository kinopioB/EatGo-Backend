package com.kinopio.eatgo.store.dao;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

public interface StoreDao {
	
	List<StoreDto> selectStores();
	StoreResponseDto selectStore(int storeId);
	List<StoreSimpleResponseDto> selectAllStore();
	List<StoreSimpleResponseDto> selectCategoryStores(int categoryId);
	List<StoreSimpleResponseDto> selectTagStores(String tagName);
	StoreDetailResponseDto selectStoreDetailById(Integer storeId);
	Float selectStoreAverageRating(Integer storeId);


	List<ReviewDto> selectReviews();
	List<ReviewResponseDto> selectStoreReviews(int storeId);
	int insertReview(ReviewRequestDto reviewDto) throws Exception;


}
