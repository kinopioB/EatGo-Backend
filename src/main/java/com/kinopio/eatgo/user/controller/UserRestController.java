package com.kinopio.eatgo.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.user.dto.LoginRequestDto;
import com.kinopio.eatgo.user.dto.LoginResponseDto;
import com.kinopio.eatgo.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

	private final UserService userService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
		log.info(loginRequestDto);
		LoginResponseDto result = userService.getLoginUser(loginRequestDto);
		log.info("Result{}", result);
		return new ResponseEntity<LoginResponseDto>(result, HttpStatus.OK);
	}

	@GetMapping("/{userId}/reviews")
	public ResponseEntity<List<ReviewResponseDto>> getAllReviews(@PathVariable int userId) {

		List<ReviewResponseDto> reviewsResult = userService.getAllReviews(userId);
		return new ResponseEntity<List<ReviewResponseDto>>(reviewsResult, HttpStatus.OK);
	}

}
