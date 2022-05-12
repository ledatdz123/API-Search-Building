package com.laptrinhjavaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.ResponseDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.myexception.FieldRequiredException;
import com.laptrinhjavaweb.service.BuidingService;
import com.laptrinhjavaweb.service.filter.BuildingFilter;

@Controller
public class BuildingAPI {

	@Autowired
	private BuidingService buildingService;
	
	@RequestMapping(value="/api/building", method= RequestMethod.GET)
	@ResponseBody
	public List<BuildingSearchResponse> getBuildingSearch(
			@RequestParam(required=true) Map<Object, Object> requestParams,
			@RequestParam(value="listType", required=false) List<String> listType
			){
		requestParams.put("buildingTypes", listType);
		List<BuildingSearchResponse> results=buildingService.findAll(requestParams);
		return results;
		
	}
	
	@RequestMapping(value="/api/building/{id}", method= RequestMethod.GET)
	@ResponseBody
	public List<BuildingDTO> getBuidingDetail(@PathVariable(value="id") long id){
		return null;
	}
	
	@RequestMapping(value="/api/building",method= RequestMethod.POST)
	@ResponseBody
	public BuildingDTO createBuilding(@RequestBody BuildingDTO buildingDTO) {
		try {
			validateDataBuilding(buildingDTO);
			return buildingDTO;
		} catch (FieldRequiredException e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	private void validateDataBuilding(BuildingDTO buildingDTO) {
		// TODO Auto-generated method stub
		if(buildingDTO.getName()==null) {
			throw new FieldRequiredException("Name is required");
		}
	}

	@RequestMapping(value= "/api/building", method= RequestMethod.PUT)
	@ResponseBody
	public void updateBuilding(){
	}
	
	@RequestMapping(value= "/api/building", method= RequestMethod.DELETE)
	@ResponseBody
	public void deleteBuilding(){
	}
}
