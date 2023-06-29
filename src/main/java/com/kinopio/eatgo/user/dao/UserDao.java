package com.kinopio.eatgo.user.dao;

import java.util.List;

import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.user.dto.LoginResponseDto;

public interface UserDao {

	LoginResponseDto selectUserById();

	List<ReviewResponseDto> selectStoreReviews(int userId);

   
}
