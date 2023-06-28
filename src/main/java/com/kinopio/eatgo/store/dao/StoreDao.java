package com.kinopio.eatgo.store.dao;

import java.util.List;

import com.kinopio.eatgo.store.dto.StoreDto;

public interface StoreDao {
	List<StoreDto> selectStores();
}
