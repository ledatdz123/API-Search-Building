package com.laptrinhjavaweb.converter;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.IDistrictRepository;
import com.laptrinhjavaweb.repository.entity.BuidingEntity;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;

@Component
public class BuildingConverter {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BuildingRepository buildingRepository;
	
	public BuildingDTO convertToDTOFromEntity(BuidingEntity buidingEntity) {
		BuildingDTO dto=modelMapper.map(buidingEntity, BuildingDTO.class);
		dto.setAddress(buidingEntity.getStreet()+","+buidingEntity.getWard());
		return dto;
	}
	
	public BuildingSearchResponse converToBuildingSearchResponseFromEntity(BuidingEntity buidingEntity,
			DistrictEntity districtEntity) {
		BuildingSearchResponse dto=modelMapper.map(buidingEntity, BuildingSearchResponse.class);
		dto.setAddress(buidingEntity.getStreet()+" "+buidingEntity.getWard()+" "+districtEntity.getName());
		return dto;
	}
	public BuildingSearchRequest convertToBuildingSearchRequestFromEntity(Map<Object, Object> requestParams) {
		BuildingSearchRequest dto=modelMapper.map(requestParams, BuildingSearchRequest.class);
		return dto;
	}
}
