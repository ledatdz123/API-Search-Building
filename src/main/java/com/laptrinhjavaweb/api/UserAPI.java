package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laptrinhjavaweb.dto.UserDTO;

@Controller
public class UserAPI {
	
	@RequestMapping(value="/api/staffs", method=RequestMethod.GET)
	@ResponseBody
	public List<UserDTO>getStaffs(@RequestParam(value="building_id", required=false) String buildingId){
		List<UserDTO> results=new ArrayList<>();
		UserDTO dto1=new UserDTO();
		dto1.setFullName("nguyen van a");
		dto1.setChecked("");
		results.add(dto1);
		UserDTO dto2=new UserDTO();
		dto2.setFullName("nguyen van b");
		dto2.setChecked("checked");
		results.add(dto2);
		return results;
	}
}
