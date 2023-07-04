package com.kinopio.eatgo.store.dto;

import java.util.List;

import com.kinopio.eatgo.store.entity.OpenInfo;
import com.kinopio.eatgo.store.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreSummaryResponseDto {
	// ���� ����
		private Integer storeId;
		private String storeName;
		private String address;
		private Integer postionX;
		private Integer postionY;
		private Integer isOpen;
		
		private Integer userId;
		private String userName;

		// ī�װ� ����
		private Integer categoryId;
		private String categoryName;
		
		// �±� ����
		private List<Tag> tags;
		
		// ���� ����
		private List<OpenInfo> openInfos;
		
		// ���� ���� ���
		private Integer ratingAverage;

}
