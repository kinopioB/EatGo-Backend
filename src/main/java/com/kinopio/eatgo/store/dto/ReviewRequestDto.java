package com.kinopio.eatgo.store.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD:src/main/java/com/kinopio/eatgo/store/dto/ReviewRequestDto.java
public class ReviewRequestDto {
	private Integer userId;
	private Integer storeId;
	private String content;
	private Integer rating;
=======
public class ReviewDto {
	
	private int userId;
	private int storeId;
	private String userName;
	private String content;
	private int rating;
	private Date createdAt;
>>>>>>> develop:src/main/java/com/kinopio/eatgo/store/dto/ReviewDto.java
}
