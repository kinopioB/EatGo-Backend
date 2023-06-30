package com.kinopio.eatgo.store.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenInfo {

	private Integer openInfoId;
	private Integer storeId;
	private String day;
	private String openTime;
	private String closeTime;
}
