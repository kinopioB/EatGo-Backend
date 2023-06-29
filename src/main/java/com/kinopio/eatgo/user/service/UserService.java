package com.kinopio.eatgo.user.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.user.dto.LoginResponseDto;

public interface UserService {

	LoginResponseDto getLoginUser();

	List<ReviewResponseDto> getAllReviews(int userId);

}
