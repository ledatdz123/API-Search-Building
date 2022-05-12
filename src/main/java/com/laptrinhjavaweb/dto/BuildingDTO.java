package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class BuildingDTO extends ResponseDTO{

	private String name;
	private Integer numberOfBasement;
	private List<String> types=new ArrayList<>();
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
	