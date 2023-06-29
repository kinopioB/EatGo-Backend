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
public class StoreResponseDto {

	// 媛�寃� �젙蹂�
	private Integer storeId;
	private String storeName;
	private String address;
	private Integer positionX;
	private Integer positionY;
	private Integer isOpen;
	
	private Integer userId;
	private String userName;

	// 移댄뀒怨좊━ �젙蹂�
	private Integer categoryId;
	private String categoryName;
	
	// �깭洹� �젙蹂�
	private List<Tag> tags;
	
	// �쁺�뾽 �젙蹂�
	private List<OpenInfo> openInfos;
	
	// 由щ럭 �룊�젏 �룊洹�
	private Integer ratingAverage;
	
	
}
