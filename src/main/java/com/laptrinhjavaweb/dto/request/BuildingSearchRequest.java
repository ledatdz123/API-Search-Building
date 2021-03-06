package com.laptrinhjavaweb.dto.request;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class BuildingSearchRequest {

	private String name;
	private String street;
	private String ward;
	private String districtCode;
	private Long districtID;
	private Integer floorArea;
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private Integer rentPriceFrom;
	private Integer rentPriceTo;
	private Integer rentEreaFrom;
	private Integer rentEreaTo;
	private String managerName;
	private String managerPhone;
	private Long staffId;
	private List<String> buildingTypes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public Long getDistrictID() {
		return districtID;
	}
	public void setDistrictID(Long districtID) {
		this.districtID = districtID;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getRentPriceFrom() {
		return rentPriceFrom;
	}
	public void setRentPriceFrom(Integer rentPriceFrom) {
		this.rentPriceFrom = rentPriceFrom;
	}
	public Integer getRentPriceTo() {
		return rentPriceTo;
	}
	public void setRentPriceTo(Integer rentPriceTo) {
		this.rentPriceTo = rentPriceTo;
	}
	public Integer getRentEreaFrom() {
		return rentEreaFrom;
	}
	public void setRentEreaFrom(Integer rentEreaFrom) {
		this.rentEreaFrom = rentEreaFrom;
	}
	public Integer getRentEreaTo() {
		return rentEreaTo;
	}
	public void setRentEreaTo(Integer rentEreaTo) {
		this.rentEreaTo = rentEreaTo;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public List<String> getBuildingTypes() {
		return buildingTypes;
	}
	public void setBuildingTypes(List<String> buildingTypes) {
		this.buildingTypes = buildingTypes;
	}
	
}
