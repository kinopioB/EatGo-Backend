package com.kinopio.eatgo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreHistoryRequestDto {

	private Integer storeId;
	private String address;
	private Double positionX;
	private Double positionY;
}
