package com.kinopio.eatgo.store.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kinopio.eatgo.store.dto.ReviewDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class StoreDaoImpl implements StoreDao{
	private final SqlSession sqlSession;
	 
	@Override
	public List<StoreDto> selectStores() {
		String statement = "store.selectStores";
		return sqlSession.selectList(statement);
	}

	public List<StoreSimpleResponseDto> selectAllStore() {
		String statement = "store.selectAllStore";
		return sqlSession.selectList(statement);
	}

	@Override
	public StoreDetailResponseDto selectStoreDetailById(Integer storeId) {
		String statement = "store.selectStoreDetailById";
		StoreDetailResponseDto result = sqlSession.selectOne(statement, storeId);
		log.info("result id: {}" , storeId);
		log.info("result return : {}" ,result);
		return result;
	}
	
	@Override
	public Float selectStoreAverageRating(Integer storeId) {
		String statement = "store.selectAverageRating";
		return sqlSession.selectOne(statement, storeId);
	}
	
	
	@Override
	public List<ReviewDto> selectReviews() {
		String statement = "store.selectReviews";
		return sqlSession.selectList(statement);
	}

	@Override
	public int insertReview(ReviewDto reviewDto) {
		String statement = "store.insertReview";
		return sqlSession.insert(statement, reviewDto);
	}
	
	
	
}
