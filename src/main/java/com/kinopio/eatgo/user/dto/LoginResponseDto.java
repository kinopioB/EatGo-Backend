package com.kinopio.eatgo.user.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDto {
	 private int userId;
	 private String userSocialId;
	 private String userName;
	 private int loginType;
	 private int role;
	 private String jwt;
}
