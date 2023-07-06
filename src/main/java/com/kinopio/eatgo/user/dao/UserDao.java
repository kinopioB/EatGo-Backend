package com.kinopio.eatgo.user.dao;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.user.dto.LoginRequestDto;
import com.kinopio.eatgo.user.dto.LoginResponseDto;

public interface UserDao {

	LoginRequestDto selectUserById(String userSocialId);

	List<ReviewResponseDto> selectStoreReviews(int userId);
	
	LoginRequestDto insertUser(LoginRequestDto loginRequestDto);
	
	String updateUserFireBaseToken(int userId, String token);
   
}
