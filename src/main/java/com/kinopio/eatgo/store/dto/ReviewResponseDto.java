package com.kinopio.eatgo.store.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDto {
	
	private Integer userId;
	private Integer storeId;
	private String content;
	private String userName;
	private Integer rating;
	private String createdAt;
}
