package com.kinopio.eatgo.store.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

	private Integer tagId;
	private Integer storeId;
	private String tagName;
	
}
