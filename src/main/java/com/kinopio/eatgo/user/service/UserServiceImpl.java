package com.kinopio.eatgo.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.user.controller.UserRestController;
import com.kinopio.eatgo.user.dao.UserDao;
import com.kinopio.eatgo.user.dto.LoginRequestDto;
import com.kinopio.eatgo.user.dto.LoginResponseDto;
import com.kinopio.eatgo.util.JwtUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserDao userDao;
	
	@Transactional
	@Override
	public LoginResponseDto getLoginUser(LoginRequestDto loginRequestDto) {
		JwtUtil jwtUtil = new JwtUtil();
		LoginRequestDto temp = userDao.selectUserById(loginRequestDto.getUserSocialId());
		log.info(temp);
		if (temp == null) {
			log.info("123123123123");
			temp = userDao.insertUser(loginRequestDto);
			log.info("9999999999999" + temp);
		}
		String jwt = "";
		
		try {
			jwt = jwtUtil.createJwt(temp);
		} catch (Exception e) {
			throw new Error(e);
		}
		LoginResponseDto loginResponseDto = LoginResponseDto.builder()
											.userId(temp.getUserId())
											.userSocialId(temp.getUserSocialId())
											.userName(temp.getUserName())
											.loginType(temp.getLoginType())
											.role(temp.getRole())
											.jwt(jwt)
											.build();
		return loginResponseDto;
	}

	@Override
	public List<ReviewResponseDto> getAllReviews(int userId) {
		return userDao.selectStoreReviews(userId);
	}

	
}
