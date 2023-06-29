package com.kinopio.eatgo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
	
	private Integer userId;
	private Integer storeId;
	private String content;
	private Integer rating;
	private String createdAt;
}
