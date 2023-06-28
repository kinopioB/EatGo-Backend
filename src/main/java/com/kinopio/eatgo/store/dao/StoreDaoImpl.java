package com.kinopio.eatgo.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kinopio.eatgo.store.dto.StoreDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreDaoImpl implements StoreDao{
	private final SqlSession sqlSession;
	 
	@Override
	public List<StoreDto> selectStores() {
		String statement = "store.selectStores";
		return sqlSession.selectList(statement);
	}
}
