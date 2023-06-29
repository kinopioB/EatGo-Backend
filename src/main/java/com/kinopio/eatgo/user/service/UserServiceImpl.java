package com.kinopio.eatgo.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.user.dao.UserDao;
import com.kinopio.eatgo.user.dto.LoginResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserDao userDao;

	@Override
	public LoginResponseDto getLoginUser() {
		return userDao.selectUserById();
	}

	@Override
	public List<ReviewResponseDto> getAllReviews(int userId) {
		return userDao.selectStoreReviews(userId);
	}

	
}
