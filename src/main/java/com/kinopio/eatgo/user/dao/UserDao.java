package com.kinopio.eatgo.user.dao;

import com.kinopio.eatgo.user.dto.LoginResponseDto;

public interface UserDao {

	LoginResponseDto selectUserById();

   
}
