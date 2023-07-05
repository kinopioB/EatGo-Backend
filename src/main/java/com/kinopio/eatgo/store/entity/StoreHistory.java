package com.kinopio.eatgo.store.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreHistory {
	
	private Integer storyHistoryId;
	private Integer storeId;
	private Date openDate;
	private String address;
	private Double positionX;
	private Double positionY;

}
