package com.hanul.middle;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import member.AndMemberDAO;
import member.MemberVO;

@RestController @RequestMapping("/member")
public class MemberController {
	//1. 크롬창을 이용해서 url Get 방식으로 login처리가 "Y"와 "N"이 되는지 확인.
	//2. Android에서 되는지 확인 <- And00_Login 프로젝트 생성 후 개발 환경 직접 구축.
	//3. Android에서 Edittext를 이용해서 되는지 확인.
//	@Autowired AndMemberDAO dao;
	@Autowired @Qualifier ("hanul") SqlSession sql;
	
	
	@RequestMapping(value="/login",produces="text/html;charset=utf-8")
	public String login(MemberVO vo) {
//		MemberVO vo = new MemberVO();
//		vo.setId("adfa");
//		vo.setPassword("adffa");
		vo = sql.selectOne("member.test",vo);
//		AndMemberDAO dao = new AndMemberDAO();
//		HashMap<String,String> params = new HashMap<String, String>();
//		params.put("id", id);
//		params.put("password", pw);
//		MemberVO vo = dao.login(params);
		
		
		Gson gson = new Gson();
		
		return gson.toJson(vo);
	}
	
	
	
//	@RequestMapping(value="/login",produces="text/html;charset=utf-8")
//	public String login(String id, String pw) {
//		if(id.equals("admin")&&pw.equals("admin1234")) {
//			System.out.println("로그인 성공");
//			return "Y";
//		}else {
//			System.out.println("실패");
//			return "N";
//		}
			
	}

