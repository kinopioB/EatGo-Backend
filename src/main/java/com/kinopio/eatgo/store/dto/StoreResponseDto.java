package com.kinopio.eatgo.store.dto;

import java.util.List;

import com.kinopio.eatgo.store.entity.OpenInfo;
import com.kinopio.eatgo.store.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponseDto {

	// 가게 정보
	private Integer storeId;
	private String storeName;
	private String address;
	private Integer postionX;
	private Integer postionY;
	private Integer isOpen;
	
	private Integer userId;
	private String userName;

	// 카테고리 정보
	private Integer categoryId;
	private String categoryName;
	
	// 태그 정보
	private List<Tag> tags;
	
	// 영업 정보
	private List<OpenInfo> openInfos;
	
	// 리뷰 평점 평균
	private Float ratingAverage;
	
	
}
