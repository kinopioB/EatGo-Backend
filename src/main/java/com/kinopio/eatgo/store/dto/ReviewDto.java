package com.kinopio.eatgo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
	
	private int userId;
	private int storeId;
	private String content;
	private int rating;
}
