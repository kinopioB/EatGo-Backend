package com.kinopio.eatgo.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenInfo {

	private Integer openInfoId;
	private Integer storeId;
	private String day;
	private String openTime;
	private String closeTime;
}
