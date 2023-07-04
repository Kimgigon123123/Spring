package com.hanul.middle;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import customer.CustomerVO;




@RestController
public class HomeController {
	//RestAPI : Page가 필요할때의 요청이 아니라 데이터가 필요할때 파라메터를 주고 데이터를 요청함.
	// 대부분 json이나 xml 형태로 데이터를 return 해준다.
	// json { "key" : "value" }
	
	//            V=>M=>C
	// 요청 => Controller => Database 조회(Model) = View
	// Android 화면 => 요청(Controller) => Model => Android 화면
	
	@Autowired @Qualifier("hanul") SqlSession sql;
	
	

	
	//@ResponseBody => RestController
	@RequestMapping(value = "/")
	public String home(HttpServletResponse res) throws IOException {
//		int result = sql.selectOne("test.dual");
//		res.getWriter().println(result);
		//응답을 하고나서는 다시 응답을 하는것은 오류라고 인식함. (response가 응답을 이미 처리함. page x )
		
		List<CustomerVO> list =sql.selectList("test.list");
		
		return list.get(4).getId()+"";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		int result = sql.selectOne("test.dual");
		model.addAttribute("list",result);
		return "list/list";
	}
	
}
