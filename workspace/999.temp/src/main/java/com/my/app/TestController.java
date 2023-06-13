package com.my.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import customer.MemberVO;


@Controller // 1. 컨트롤러 생성 @Controller
public class TestController {

	String hi ="안녕";
	
	// 2. 어떤 요청에 대해 연결할 것인지 지정 @RequestMapping()
	@RequestMapping("/first")
	public String view (Model model) {
		model.addAttribute("hi",hi);
		return "index";
	}
	
	@RequestMapping("/table")
	public String table() {
		return "member/tabletest";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member/join";
	}
	
	@RequestMapping("/joinRequest")
	public String join(HttpServletRequest request, Model model) {
		//데이터를 전달할 때에는 모델에 담아서전달하는데 전달할 데이터는 request에 담겨있다.
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("gender", request.getParameter("gender"));
		model.addAttribute("email", request.getParameter("email"));
		model.addAttribute("method", "HttpServletRequest");
		
		return "member/info";
	}
	
	@RequestMapping("/joinDataObject")
	public String join(MemberVO vo, Model model){
		model.addAttribute("vo",vo);
		return "member/info";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("/login_result")
	public String login(String id, String pw) {
		if(id.equals("hong")&&pw.equals("1234")) {
			return "redirect:/";
		}
		else {
			return "redirect:login";
		}
	}

	
	
}
