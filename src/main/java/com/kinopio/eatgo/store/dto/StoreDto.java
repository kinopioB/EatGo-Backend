package com.kinopio.eatgo.store.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {
	private int id;
	private String name;
	private int userId;
	private String address;
	private Double positionX;
	private Double positionY;
	private int isOpen;
	private int categoryId;
	private String thumbnail;
	private Date createdAt;
}
