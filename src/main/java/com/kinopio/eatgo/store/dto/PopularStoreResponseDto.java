package com.kinopio.eatgo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopularStoreResponseDto {

	private Integer storeId;
	private String storeName;
	private String thumbnail;
	
	
	private String info;
	
	private Integer categoryId;
	private String categoryName;
	
	private Integer reviewCount;
	
	
}
