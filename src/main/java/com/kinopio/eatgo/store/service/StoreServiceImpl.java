package com.kinopio.eatgo.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kinopio.eatgo.store.dao.StoreDao;
import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDto;
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
	public List<StoreDto> getStores() { // 삭제 예정
		return null;
	}

	@Override
	public List<StoreSimpleResponseDto> getAllStores() {
		return storeDao.selectAllStore();
	}

	@Override
	public List<ReviewDto> getAllReviews() {
		return storeDao.selectReviews();
	}

	@Override
	public Boolean createReview(ReviewDto reviewDto) {
		try {
			storeDao.insertReview(reviewDto);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ReviewDto> getAllStoreReviews(int storeId) {
		return storeDao.selectStoreReviews(storeId);
	}
}
