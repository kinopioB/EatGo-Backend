package com.kinopio.eatgo.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kinopio.eatgo.store.dao.StoreDao;
import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreRequestDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

	private final StoreDao storeDao;

	@Override
	public List<StoreSimpleResponseDto> getAllStores() {
		return storeDao.selectAllStore();
	}

	@Override
	public Boolean createReview(ReviewRequestDto reviewRequestDto) {
		try {
			storeDao.insertReview(reviewRequestDto);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ReviewResponseDto> getAllStoreReviews(int storeId) {
		return storeDao.selectStoreReviews(storeId);
	}

	@Override
	public List<StoreSimpleResponseDto> getCategoryStores(int categoryId) {
		return storeDao.selectCategoryStores(categoryId);
	}

	@Override
	public List<StoreSimpleResponseDto> getTagStores(String tagName) {
		return storeDao.selectTagStores(tagName);
	}
	


	@Override
	public StoreResponseDto getStore(int storeId) {
		return storeDao.selectStore(storeId);
	}


	@Override
	public StoreDetailResponseDto getStoreDetail(int storeId) {
		StoreDetailResponseDto storeDetail = storeDao.selectStoreDetailById(storeId);
		storeDetail.setRatingAverage(storeDao.selectStoreAverageRating(storeId));
		return storeDetail;
	}

	
	
	@Override
	public List<ReviewDto> getAllReviews() {
		return storeDao.selectReviews();
	}

	@Override
	public Boolean createStore(StoreRequestDto storeRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
