package com.kinopio.eatgo.store.dao;

import java.util.List;

import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

public interface StoreDao {
	List<StoreDto> selectStores();

	List<StoreSimpleResponseDto> selectAllStore();
}
