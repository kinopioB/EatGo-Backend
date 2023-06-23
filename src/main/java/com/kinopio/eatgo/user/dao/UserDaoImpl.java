package com.kinopio.eatgo.user.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kinopio.eatgo.user.dto.LoginResponseDto;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final SqlSession sqlSession;

	@Override
	public LoginResponseDto selectUserById() {

		String statment = "user.selectUserById";
		return sqlSession.selectOne(statment);
	}

    
}
