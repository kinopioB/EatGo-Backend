package com.kinopio.eatgo.store.dto;

import java.util.List;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreRequestDto {

	// 가게 정보 
	private String storeName;
	private Integer userId;
	private String address;
	private Double positionX;
	private Double positionY;
	private Integer categoryId;
	private String thumbnail;
	private Integer createdType;
	
	// 메뉴 정보
	private List<MenuRequestDto> menus;
	
	// 영업일 정보
	private List<OpenInfoRequestDto> openInfos;
	
	// 태그 정보 
	private List<TagRequestDto> tags;
}
