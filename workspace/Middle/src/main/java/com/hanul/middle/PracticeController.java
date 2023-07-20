package com.hanul.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import hr.HrVO;
import practice.PracticeVO;

@RestController
public class PracticeController {

@Autowired @Qualifier ("hanul") SqlSession sql;
	
	@RequestMapping(value="/pc_select",produces="text/html;charset=utf-8")
		public String select() {
		
		List<PracticeVO> list = sql.selectList("practice.select");
		
		
			Gson gson = new Gson();
		
		return gson.toJson(list);
	}
	
	@RequestMapping(value="/pc_insert",produces="text/html;charset=utf-8")
	public String insert(String col1) {
		
		int result = sql.insert("practice.insert",col1);
		List<PracticeVO> list = sql.selectList("practice.select");
		
			Gson gson = new Gson();
		
		return gson.toJson(list);
	}
	





		@RequestMapping(value="/pc_update",produces="text/html;charset=utf-8")
		public String update(String col1) {
			
			int result = sql.update("practice.update",col1);
			
				Gson gson = new Gson();
			
			return gson.toJson(result);
		}
		
		
		@RequestMapping(value="/pc_delete",produces="text/html;charset=utf-8")
		public String delete(String id) {
			
			int result = sql.delete("practice.delete",id);
			
				Gson gson = new Gson();
			
			return gson.toJson(result);
		}
		
		}
