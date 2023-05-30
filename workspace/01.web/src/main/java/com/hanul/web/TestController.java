package com.hanul.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("/second")
	public ModelAndView second() {
		//비지니스로직
		SimpleDateFormat sdf = new SimpleDateFormat("hh시 mm분 ss초");
		String now = sdf.format(new Date());
		
		ModelAndView model = new ModelAndView();
		model.addObject("now",now);
		
		//응답화면지정
		model.setViewName("index");
		return model;
	}

	@RequestMapping("/first")
	public String first(Model model) {
		//비지니스로직
	String today=	new  SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
		model.addAttribute("today",today);
		//응답화면연결
		return "index";
	}
	
	@RequestMapping("/third")
	public String third(Model model) {
		String now = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초").format(new Date());
		model.addAttribute("now",now);
		return "now";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member/join";
	}
	
	@RequestMapping("/joinRequest")
	public String join(HttpServletRequest request,Model model) {
		//전송된 파라미터 접근
		String name = request.getParameter("name");
		model.addAttribute("gender",request.getParameter("gender"));
		model.addAttribute("email",request.getParameter("email"));
		
		
		//파라미터값을 정보화면에 출력할 수 있도록 Model에 담기
		model.addAttribute("name",name);
		model.addAttribute("method","HttpServletRequest 방식");
		return "member/info";
	}
	
}
