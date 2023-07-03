package com.kinopio.eatgo.store.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.PopularStoreResponseDto;
import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreHistoryRequestDto;
import com.kinopio.eatgo.store.dto.StoreModificationResponseDto;
import com.kinopio.eatgo.store.dto.StoreMyPageResponseDto;
import com.kinopio.eatgo.store.dto.StoreRequestDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;
import com.kinopio.eatgo.store.dto.TodayOpenStoreResponseDto;

public interface StoreService {
	
	
	List<StoreSimpleResponseDto> getAllStores();
	StoreResponseDto getStore(int storeId);
	StoreDetailResponseDto getStoreDetail(int storeId);


	List<StoreSimpleResponseDto> getCategoryStores(int categoryId);

	List<StoreSimpleResponseDto> getTagStores(String tagName);
	

	List<PopularStoreResponseDto> getPopularStores();
	
	List<TodayOpenStoreResponseDto> getTodayOpenStores();


	StoreDetailResponseDto createStore(StoreRequestDto storeRequestDto);


	Boolean changeStoreStatusOpen(StoreHistoryRequestDto storeHistoryRequestDto);
	
	Boolean changeStoreStatusClose(int storeId);


	List<ReviewResponseDto> getAllStoreReviews(int storeId);

	Boolean createReview(ReviewRequestDto reviewRequestDto);
	
	StoreMyPageResponseDto getStoreMyPage(int storeId);
	StoreModificationResponseDto getModificationStoreMyPage(int storeId);
	
}
