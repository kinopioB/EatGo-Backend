package com.kinopio.eatgo.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
	 private int userId;
	 private String userSocialId;
	 private String userName;
	 private int loginType;
	 private int role;
}
