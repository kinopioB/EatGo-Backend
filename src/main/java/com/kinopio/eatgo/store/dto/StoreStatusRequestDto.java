package com.kinopio.eatgo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreStatusRequestDto {
	
	private Integer StoreId;
	private Integer changeStatus;
}
