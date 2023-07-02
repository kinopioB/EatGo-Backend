package com.kinopio.eatgo.store.dto;

import java.util.List;

import com.kinopio.eatgo.store.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodayOpenStoreResponseDto {

	private Integer storeId;
	private String storeName;
	private String thumbnail;
	private String info;
	
	private Integer categoryId;
	private String categoryName;
	
	private List<Tag> tags;
	
}
