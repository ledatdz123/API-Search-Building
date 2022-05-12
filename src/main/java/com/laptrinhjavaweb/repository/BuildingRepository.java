package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.repository.entity.BuidingEntity;


public interface BuildingRepository {

	List<BuidingEntity> findAll(Map<Object, Object> requestParams);
}
