package com.kinopio.eatgo.store.dto;

import java.sql.Date;
import java.util.List;

import com.kinopio.eatgo.store.entity.Menu;
import com.kinopio.eatgo.store.entity.OpenInfo;
import com.kinopio.eatgo.store.entity.Review;
import com.kinopio.eatgo.store.entity.StoreHistory;
import com.kinopio.eatgo.store.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class StoreDetailResponseDto {

	// 가게 정보
	private Integer storeId;
	private String storeName;
	private String address;
	private Integer postionX;
	private Integer postionY;
	private Integer isOpen;
	private String thumbnail;
	private Integer createdType;
	private Date createdAt;
	
	private Integer userId;
	private String userName;

	// 카테고리 정보
	private Integer categoryId;
	private String categoryName;
	
	// 태그 정보
	private List<Tag> tags;
	
	// 영업 정보
	private List<OpenInfo> openInfos;
	
	// 영업 이력 정보 
	private List<StoreHistory> storeHistorys;
	
	// 메뉴 정보
	private List<Menu> menus;
	
	// 리뷰
	private List<Review> reviews;
	
	// 리뷰 평점 평균
	private Integer ratingAverage;
	
	
	
}
