package com.kinopio.eatgo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenInfoRequestDto {

	private Integer storeId;
	private String day;
	private String openTime;
	private String closeTime;
}
