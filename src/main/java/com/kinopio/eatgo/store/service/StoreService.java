package com.kinopio.eatgo.store.service;

import java.util.List;

import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

public interface StoreService {
	
	List<StoreDto> getStrores(); // 삭제 예정 

	List<StoreSimpleResponseDto> getAllStore();
}
