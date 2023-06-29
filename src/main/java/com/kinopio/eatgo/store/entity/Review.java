package com.kinopio.eatgo.store.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	
	private Integer reviewId;
	private Integer userId;
	private Integer storeId;
	private Integer content;
	private Integer rating;
	private Date createdAt;
}
