package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.IDistrictRepository;
import com.laptrinhjavaweb.repository.entity.BuidingEntity;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;
import com.laptrinhjavaweb.service.BuidingService;
import com.laptrinhjavaweb.service.filter.BuildingFilter;
@Service
public class BuildingServiceImpl implements BuidingService{

	@Autowired
    private BuildingRepository buildingRepository;
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private IDistrictRepository districtRepository;
	@Override
	public List<BuildingSearchResponse> findAll(Map<Object, Object> requestParams) {
		// TODO Auto-generated method stub
		List<BuidingEntity> building=buildingRepository.findAll(requestParams);
		List<BuildingSearchResponse> buildingDTOs=new ArrayList<>();
		for (BuidingEntity item : building) {
			DistrictEntity districtEntity=districtRepository.getDistrict(item.getDistrictId());
			BuildingSearchResponse buildingDto=buildingConverter.converToBuildingSearchResponseFromEntity(item, districtEntity);
			
			buildingDTOs.add(buildingDto);
		}
		return buildingDTOs;
	}
}
