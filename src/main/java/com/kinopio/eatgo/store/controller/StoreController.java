package com.kinopio.eatgo.store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.service.StoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("stores")
public class StoreController {
	private final StoreService storeService;
	
	@GetMapping("locations")
	public ResponseEntity<Map<String, List>> getAllStroesLocations() {
		List<StoreDto> list = storeService.getAllStores();
		Map<String, List> result = new HashMap<>();
		result.put("res", list);
		log.info(list);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
}
