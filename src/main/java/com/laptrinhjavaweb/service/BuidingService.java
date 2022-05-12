package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.service.filter.BuildingFilter;

public interface BuidingService {

	List<BuildingSearchResponse> findAll(Map<Object, Object> requestParams);
}
