package com.kinopio.eatgo.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
	
	private Integer menuId;
	private Integer storeId;
	private String menuName;
	private Integer price;
	private Integer amount;
	private String thumbnail;
	private Integer isBest;
	
}
