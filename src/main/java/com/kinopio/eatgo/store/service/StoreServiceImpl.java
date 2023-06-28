package com.kinopio.eatgo.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kinopio.eatgo.store.dao.StoreDao;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
	
	private final StoreDao storeDao;
	


	@Override
	public List<StoreSimpleResponseDto> getAllStore() {
		
		return storeDao.selectAllStore();
	}
	@Override
	public List<StoreDto> getStrores() { // 삭제 예정 
		return null;
	}
}
