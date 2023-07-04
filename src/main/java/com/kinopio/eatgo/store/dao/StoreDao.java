package com.kinopio.eatgo.store.dao;

import java.util.List;

import com.kinopio.eatgo.store.dto.PopularStoreResponseDto;
import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreHistoryRequestDto;
import com.kinopio.eatgo.store.dto.StoreModificationResponseDto;
import com.kinopio.eatgo.store.dto.StoreMyPageResponseDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;
import com.kinopio.eatgo.store.dto.StoreStatusRequestDto;
import com.kinopio.eatgo.store.dto.StoreSummaryResponseDto;
import com.kinopio.eatgo.store.dto.TodayOpenStoreResponseDto;
import com.kinopio.eatgo.store.entity.Menu;
import com.kinopio.eatgo.store.entity.OpenInfo;
import com.kinopio.eatgo.store.entity.Tag;

public interface StoreDao {
	
	List<StoreDto> selectStores();
	StoreResponseDto selectStore(int storeId);
	List<StoreSimpleResponseDto> selectAllStore();
	List<StoreSimpleResponseDto> selectCategoryStores(int categoryId);
	List<StoreSimpleResponseDto> selectTagStores(String tagName);
	StoreDetailResponseDto selectStoreDetailById(Integer storeId);
	Float selectStoreAverageRating(Integer storeId);
	List<PopularStoreResponseDto> selectPopularStores();
	List<TodayOpenStoreResponseDto> selectTodayOpenStores();


	StoreDto insertStore(StoreDto storeDto) throws Exception;
	int insertMenus(List<Menu> menus) throws Exception;
	int insertTags(List<Tag> tags) throws Exception;
	int insertOpenInfos(List<OpenInfo> openInfos) throws Exception;
	int updateStoreOpenStatus(StoreHistoryRequestDto StoreHistoryRequestDto);
	int updateStoreCloseStatus(int storeId);
	int insertStoreHistory(StoreHistoryRequestDto storeHistoryRequestDto);	


	List<ReviewResponseDto> selectStoreReviews(int storeId);
	int insertReview(ReviewRequestDto reviewDto) throws Exception;
  
  
	StoreMyPageResponseDto selectStoreMyPage(int storeId);
	Integer selectReviewCount(int storeId);
	StoreModificationResponseDto selectStoreModificationMyPage(int storeId);

	
	
	List<StoreSimpleResponseDto> selectFilterStore(String searchFilter);

}
