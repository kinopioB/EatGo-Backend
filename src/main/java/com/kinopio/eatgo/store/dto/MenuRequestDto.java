package com.kinopio.eatgo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequestDto {
	
	private String menuName;
	private Integer price;
	private Integer amount;
	private String info;
	private String thumbnail;
	private Integer isBest;
}
