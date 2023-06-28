package com.kinopio.eatgo.store.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {
	private Integer id;
	private String name;
	private Integer userId;
	private String address;
	private Double positionX;
	private Double positionY;
	private Integer isOpen;
	private Integer categoryId;
	private String thumbnail;
	private Date createdAt;
}
