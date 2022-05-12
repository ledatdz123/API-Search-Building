package com.laptrinhjavaweb.dto.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ResponseDTO;

@Component
public class BuildingSearchResponse extends ResponseDTO{
	
	private String name;
	
	private String address;

	private Integer floorarea;

	private Integer rentPrice;
	
	private String rentPriceDescription;
	
	private String servicefee;

	private String brokeragefee;
	
	private String managername;
	
	private String managerphone;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}

	public Integer getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getRentPriceDescription() {
		return rentPriceDescription;
	}

	public void setRentPriceDescription(String rentPriceDescription) {
		this.rentPriceDescription = rentPriceDescription;
	}

	public String getServicefee() {
		return servicefee;
	}

	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}

	public String getBrokeragefee() {
		return brokeragefee;
	}

	public void setBrokeragefee(String brokeragefee) {
		this.brokeragefee = brokeragefee;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManagerphone() {
		return managerphone;
	}

	public void setManagerphone(String managerphone) {
		this.managerphone = managerphone;
	}
	
}
