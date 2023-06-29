package com.kinopio.eatgo.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreDaoImpl implements StoreDao {
	private final SqlSession sqlSession;

	@Override
	public List<StoreDto> selectStores() {
		String statement = "store.selectStores";
		return sqlSession.selectList(statement);
	}

	@Override
	public int insertReview(ReviewRequestDto reviewRequestDto) throws Exception {
		String statement = "store.insertReview";
		return sqlSession.insert(statement, reviewRequestDto);
	}

	public List<StoreSimpleResponseDto> selectAllStore() {
		String statement = "store.selectAllStore";
		return sqlSession.selectList(statement);
	}

	@Override
	public List<ReviewResponseDto> selectStoreReviews(int storeId) {
		String statement = "store.selectStoreReviews";
		return sqlSession.selectList(statement, storeId);
	}

	@Override
	public List<StoreSimpleResponseDto> selectCategoryStores(int categoryId) {
		String statement = "store.selectCategoryStores";
		return sqlSession.selectList(statement, categoryId);
	}

	@Override
	public List<StoreSimpleResponseDto> selectTagStores(String tagName) {
		String statement = "store.selectTagStores";
		return sqlSession.selectList(statement, tagName);
	}
	
}
