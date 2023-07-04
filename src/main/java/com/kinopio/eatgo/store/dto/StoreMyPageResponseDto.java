package com.kinopio.eatgo.store.dto;

import java.util.List;

import com.kinopio.eatgo.store.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreMyPageResponseDto {
	private Integer storeId;
	private String userName;
	private String storeName;
	private String thumbNail;
	
	private Integer categoryId;
	private String categoryName;
	private Integer isOpen;
	private Integer reviewNum;

	private Float ratingAverage;

	private List<Tag> tags;
	private List<ReviewDto> reviews;
	


}