package com.kinopio.eatgo.user.dao;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.user.dto.LoginRequestDto;
import com.kinopio.eatgo.user.dto.LoginResponseDto;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

	private final SqlSession sqlSession;

	@Override
	public LoginRequestDto selectUserById(String userSocialId) {

		String statment = "user.selectUserById";
		return sqlSession.selectOne(statment, userSocialId);
	}

	@Override
	public List<ReviewResponseDto> selectStoreReviews(int storeId) {
		String statement = "user.selectStoreReviews";
		return sqlSession.selectList(statement, storeId);
	}
	
	@Override
	public LoginRequestDto insertUser(LoginRequestDto loginRequestDto) {
		String statement = "user.insertUser";
		sqlSession.insert(statement, loginRequestDto);
		return loginRequestDto;
	}

}
