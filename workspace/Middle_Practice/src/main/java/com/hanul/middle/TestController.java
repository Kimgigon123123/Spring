package com.hanul.middle;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class TestController {
	@Autowired @Qualifier ("hanul") SqlSession sql;
	
	@RequestMapping("/one.cu")
	public String one(int id) {
		TestVO vo = sql.selectOne("test.list",id);
		System.out.println(vo.getId());
		return "one";
	}
	
}
