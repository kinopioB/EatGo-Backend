package com.kinopio.eatgo.user.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.user.dto.LoginRequestDto;
import com.kinopio.eatgo.user.dto.LoginResponseDto;

public interface UserService {

	LoginResponseDto getLoginUser(LoginRequestDto loginRequestDto);

	List<ReviewResponseDto> getAllReviews(int userId);
	
	String setUserFireBaseToken(int userId, String token);

}
