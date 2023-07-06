package com.kinopio.eatgo.user.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.user.dto.LoginRequestDto;
import com.kinopio.eatgo.user.dto.LoginResponseDto;

@Log4j2
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
		log.info(loginRequestDto);
		sqlSession.insert(statement, loginRequestDto);
		log.info("55555555555555555555555555555");
		return loginRequestDto;
	}
	
	@Override
	public String updateUserFireBaseToken(int userId, String token) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("userId", Integer.toString(userId));
		map.put("token", token);
		
		String statement = "user.updateFireBaseToken";
		sqlSession.update(statement, map);
		
		return token;
	}

}
