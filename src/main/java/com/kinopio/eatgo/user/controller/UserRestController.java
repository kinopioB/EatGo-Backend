package com.kinopio.eatgo.user.controller;


import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinopio.eatgo.user.dto.LoginResponseDto;
import com.kinopio.eatgo.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {
	
    private final UserService userService;
    
    @GetMapping("/test")
    public ResponseEntity<LoginResponseDto> login() {
    	LoginResponseDto result = userService.getLoginUser();
    	log.info("result {} ", result);
    	return null;
       
    }


}
