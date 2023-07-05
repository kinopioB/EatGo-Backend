package com.kinopio.eatgo.store.dto;

import java.sql.Date;
import java.util.List;

import com.kinopio.eatgo.store.entity.Menu;
import com.kinopio.eatgo.store.entity.OpenInfo;
import com.kinopio.eatgo.store.entity.Review;
import com.kinopio.eatgo.store.entity.StoreHistory;
import com.kinopio.eatgo.store.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreModificationResponseDto {

	// 가게 정보
	private Integer storeId;
	private String storeInfo;
	private String address;
	private Double positionX;
	private Double positionY;
	private Integer createdType;
	
	// 영업 정보
	private List<OpenInfo> openInfos;
}
