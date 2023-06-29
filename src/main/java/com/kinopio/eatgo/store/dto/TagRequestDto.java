package com.kinopio.eatgo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagRequestDto {
	
	private Integer storeId;
	private String tagName;

}
