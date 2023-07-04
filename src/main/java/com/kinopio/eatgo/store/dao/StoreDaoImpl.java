package com.kinopio.eatgo.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreHistoryRequestDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;
import com.kinopio.eatgo.store.dto.StoreStatusRequestDto;
import com.kinopio.eatgo.store.dto.StoreSummaryResponseDto;
import com.kinopio.eatgo.store.entity.Menu;
import com.kinopio.eatgo.store.entity.OpenInfo;
import com.kinopio.eatgo.store.entity.Tag;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class StoreDaoImpl implements StoreDao {
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
	
		return result;
	}
	
	@Override
	public Float selectStoreAverageRating(Integer storeId) {
		String statement = "store.selectAverageRating";
		return sqlSession.selectOne(statement, storeId);
	}
	
	@Override
	public StoreDto insertStore(StoreDto storeDto) throws Exception {
		String statement ="store.insertStore";
		sqlSession.insert(statement, storeDto);
		return storeDto;
	}

	@Override
	public int insertMenus(List<Menu> menus) throws Exception{
		String statement ="store.insertMenus";		
		return sqlSession.update(statement,menus);
	}

	@Override
	public int insertTags(List<Tag> tags) throws Exception {
		String statement ="store.insertTags";		
		return sqlSession.update(statement,tags);
	}

	@Override
	public int insertOpenInfos(List<OpenInfo> openInfos) throws Exception {
		String statement ="store.insertOpenInfos";		
		return sqlSession.update(statement,openInfos);
	}

	@Override
	public int updateStoreOpenStatus(StoreHistoryRequestDto storeHistoryRequestDto) {
		String statement = "store.updateStoreOpenStatus";
		return sqlSession.update(statement, storeHistoryRequestDto);
	}
	@Override
	public int updateStoreCloseStatus(int storeId) {
		String statement = "store.updateStoreCloseStatus";
		return sqlSession.update(statement, storeId);
	}

	@Override
	public int insertStoreHistory(StoreHistoryRequestDto storeHistoryRequestDto) {
		String statement = "store.insertStoreHistory";
		return sqlSession.insert(statement, storeHistoryRequestDto);
	}
	
	
	@Override
	public int insertReview(ReviewRequestDto reviewRequestDto) throws Exception {
		String statement = "store.insertReview";
		return sqlSession.insert(statement, reviewRequestDto);
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
	
	
	@Override
	public StoreResponseDto selectStore(int storeId) {
		String statement = "store.selectStore";
		return sqlSession.selectOne(statement, storeId);
  }
	@Override
	public List<StoreSimpleResponseDto> selectFilterStore(String searchFilter) {
		String statement = "store.selectFilterStores";
		return sqlSession.selectList(statement, searchFilter);
	}	
}
