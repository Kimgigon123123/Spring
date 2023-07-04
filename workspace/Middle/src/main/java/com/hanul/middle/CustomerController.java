package com.hanul.middle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import customer.CustomerVO;

@RestController
public class CustomerController {
//one.cu , list.cu
	
	@Autowired @Qualifier("hanul") SqlSession sql;
	
	
	
	@RequestMapping("/one.cu")
	public String one(int id,String name) {//<= paramter 부. 사용자가 어떤 요청을 할때 데이터를 넘겨주는 부분.(받는부분)
		// Integer.parseInt(req.getParamtter("id"));
		//one<=sql.selectOne (객체 하나 , 무조건 Row가 하나여야함)
		CustomerVO tempVo = new CustomerVO();
		tempVo.setId(id);
		tempVo.setName(name);
		
		CustomerVO vo = sql.selectOne("cu.one",tempVo);
		System.out.println(vo.getName());
		return "one";
	}
	
	@RequestMapping("/list.cu")
	public String list() {
		List<CustomerVO> list = sql.selectList("cu.list");
		System.out.println(list.size());
		return list.size()+"";
	}
	
	
}
