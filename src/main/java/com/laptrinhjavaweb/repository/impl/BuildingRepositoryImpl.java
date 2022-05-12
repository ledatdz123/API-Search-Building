package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuidingEntity;
import com.laptrinhjavaweb.utils.StringUtils;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{

	private String DB_URL="jdbc:mysql://localhost:3306/estatebasic";
	private String USER="root";
	private String PASS="1234";
	
	@Autowired
	private BuildingConverter buildingConveter;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private BuildingSearchRequest buildingSearchRequest;
	
	@Override
	public List<BuidingEntity> findAll(Map<Object, Object> requestParams) {
		// TODO Auto-generated method stub
		buildingSearchRequest=buildingConveter.convertToBuildingSearchRequestFromEntity(requestParams);
		String QUERY=buildingForBuildingSearch(buildingSearchRequest);
		List<BuidingEntity> buildingEntitys=new ArrayList<>();
		try {
			Connection conn=DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(QUERY);
			while(rs.next()) {
				BuidingEntity buildingEntity=new BuidingEntity();
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setDistrictId(rs.getString("districtid"));
				buildingEntity.setFloorArea(Integer.valueOf(rs.getString("floorarea")));
				buildingEntity.setRentPrice(Integer.valueOf(rs.getString("rentprice")));
				buildingEntity.setRentPriceDescription(rs.getString("rentpricedescription"));
				buildingEntity.setServiceFee(rs.getString("servicefee"));
				buildingEntity.setRentPriceDescription(rs.getString("rentpricedescription"));
				buildingEntity.setServiceFee(rs.getString("servicefee"));
				buildingEntitys.add(buildingEntity);
			}
			return buildingEntitys;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}


	public String buildingForBuildingSearch(BuildingSearchRequest buildingSearch) {
		// TODO Auto-generated method stub
		try {
			return new StringBuilder("select bd.id, bd.name, "
					+ "bd.street, bd.ward, bd.districtid, bd.managername, "
					+ "bd.managerphone, bd.floorarea, "
					+ "bd.rentprice, bd.rentpricedescription, "
					+ "bd.servicefee, bd.brokeragefee, "
					+ "bd.createddate, bd.servicefee from building bd")
					.append(buildJoinTable(buildingSearch))
					.append(buildSQLClause(buildingSearch))
					.append(" group by bd.id").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String buildSQLClause(BuildingSearchRequest buildingSearch) {
		// TODO Auto-generated method stub
			StringBuilder whereSQL=new StringBuilder(" where 1=1 ");
			whereSQL
			.append(buildConditionForBuildingType(buildingSearch.getBuildingTypes()))
			.append(createConditionLike("bd.name", buildingSearch.getName()))
			.append(createConditionLike("bd.street", buildingSearch.getStreet()))
			.append(createConditionLike("bd.ward", buildingSearch.getWard()))
			.append(conditionDistrict(" and dt.code"," ", buildingSearch.getDistrictCode()))
			.append(createConditionLike("bd.managername", buildingSearch.getManagerName()))
			.append(createConditionLike("bd.managerphone", buildingSearch.getManagerPhone()))
			.append(createConditionLike("bd.level", buildingSearch.getLevel()))
			.append(checkCondition(" and bd.floorarea"," ", buildingSearch.getFloorArea()))
			.append(checkCondition(" and bd.numberofbasement", "", buildingSearch.getNumberOfBasement()))
			.append(checkCondition(" and asm.staffid", " ", buildingSearch.getStaffId()))
			.append(createConditionLike("direction", buildingSearch.getDirection()))
			.append(betweenCondition("re.value", buildingSearch.getRentEreaFrom(), buildingSearch.getRentEreaTo()))
			.append(betweenCondition("bd.rentprice", buildingSearch.getRentPriceFrom(), buildingSearch.getRentPriceTo()));
			return whereSQL.toString();
	}

	public String createConditionLike(String fieldName, String value) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(value)) {
			return new StringBuilder(" and ")
					.append(fieldName)
					.append(" like '%")
					.append(value)
					.append("%' ").toString();
		}
		return "";
	}
	
	public String checkCondition(String prefix, String suffix, Object parameters) {
		// TODO Auto-generated method stub
		if(parameters!=null) {
			return prefix+"="+suffix+parameters;
		}
		return "";
	}
	public String conditionDistrict(String prefix, String suffix, Object parameters) {
		// TODO Auto-generated method stub
		if(parameters!=null) {
			return prefix+"="+suffix+" '"+parameters+"' ";
		}
		return "";
	}
	public String buildJoinTable(BuildingSearchRequest buildingSearch) {
		String sql="";
		// TODO Auto-generated method stub
		String assignmentbuilding=" join assignmentbuilding asm on asm.buildingid=bd.id";
		String rentarea=" join rentarea re on re.buildingid=bd.id";
		String renttype=" join buildingrenttype brt on bd.id=brt.buildingid join renttype rt on rt.id=brt.renttypeid";
		String district=" join district dt on dt.id=bd.districtid";
		if(buildingSearch.getStaffId()!=null) {
			sql+=assignmentbuilding;
		}
		if(buildingSearch.getBuildingTypes()!=null) {
			sql+=renttype;
		}
		if(buildingSearch.getRentEreaFrom()!=null || buildingSearch.getRentEreaTo()!=null) {
			sql+=rentarea;
		}
		if(buildingSearch.getDistrictCode()!=null) {
			sql+=district;
		}
		return sql;
	}

	public String betweenCondition(String whereSQL, Integer from, Integer to) {
		// TODO Auto-generated method stub
		if(!StringUtils.isNull(from) || !StringUtils.isNull(to)) {
			if(!StringUtils.isNull(from) && !StringUtils.isNull(to)) {
				return " and "+ whereSQL +" between "+ from +" and "+ to +" ";
			}
			else if(!StringUtils.isNull(from) && StringUtils.isNull(to)) {
				return " and "+ whereSQL +" >= "+ from + " ";
			}
			else {
				return " and "+ whereSQL +" <= "+ to + " ";
			}
		
	}
		return "";
	
}
	
	public String buildConditionForBuildingType(List<String> buildingType) {
		// TODO Auto-generated method stub
		  StringBuilder sql=new StringBuilder("");
		  if(buildingType!=null) {
			  sql.append(" and ");
			  if(buildingType.size()==1) {
				  sql.append("rt.code like '"+buildingType.get(0)+"' ");
			  }
			  else if(buildingType.size()>1) {
				  for (int i = 0; i < buildingType.size(); i++) {
					sql.append("rt.code like '"+buildingType.get(i)+"' ");
					if(i<buildingType.size()-1) {
						sql.append(" or ");
					}
				}
			  }
		  }
		  return sql.toString();
	}
}