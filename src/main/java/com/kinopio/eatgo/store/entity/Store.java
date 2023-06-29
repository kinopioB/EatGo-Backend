package com.kinopio.eatgo.store.entity;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
	private Integer storeId;
	private String storeName;
	private Integer userId;
	private String address;
	private Double positionX;
	private Double positionY;
	private Integer isOpen;
	private Integer categoryId;
	private String thumbnail;
	private Integer createdType;
	private Date createdAt;
}