package com.kinopio.eatgo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreHistoryRequestDto {

	private Integer storeId;
	private String address;
	private Double positionX;
	private Double positionY;
}
