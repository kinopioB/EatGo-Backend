package com.kinopio.eatgo.store.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class StoreSimpleResponseDto {
	
	private Integer storeId;
	private String storeName;
	private String address;
	private Double positionX;
	private Double positionY;
	private Integer isOpen;
	
	private Integer categoryId;
	private String categoryName;
		
}
