package com.hanul.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import customer.CustomerVO;
import hr.HrVO;

@RestController
public class HrController {
	
	@Autowired @Qualifier ("hr") SqlSession sql;
	
	@RequestMapping(value="/hr",produces="text/html;charset=utf-8")
	public String hr() {
		
		List<HrVO> list = sql.selectList("hr.list");
		System.out.println("확인"+list.get(0).getName());
		
			Gson gson = new Gson();
		
		return gson.toJson(list);
	}
	
	
	@RequestMapping(value="/search",produces="text/html;charset=utf-8")
	public String search(String department_name) {
		
		List<HrVO> list = sql.selectList("hr.search",department_name);
//		System.out.println("확인"+list.get(0).getDepartment_name());
		
			Gson gson = new Gson();
		
		return gson.toJson(list);
	}
	

}
