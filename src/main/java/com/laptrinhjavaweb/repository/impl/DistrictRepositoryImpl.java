package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.repository.IDistrictRepository;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;

@Repository
public class DistrictRepositoryImpl implements IDistrictRepository{
	private String DB_URL="jdbc:mysql://localhost:3306/estatebasic";
	private String USER="root";
	private String PASS="1234";
	@Override
	public DistrictEntity getDistrict(String districtId) {
		// TODO Auto-generated method stub
		String query="select *from district where 1=1 and district.id = '"+districtId+"' ";
		List<DistrictEntity> districtEntitys=new ArrayList<>();
		try {
			Connection conn=DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				DistrictEntity districts=new DistrictEntity();
				districts.setCode(rs.getString("code"));
				districts.setName(rs.getString("name"));
				districtEntitys.add(districts);
			}
			return districtEntitys.size()>0 ? districtEntitys.get(0) : new DistrictEntity();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
