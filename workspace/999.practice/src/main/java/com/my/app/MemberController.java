package com.my.app;





import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import customer.CustomerDAO;
import customer.CustomerService;







@Controller
public class MemberController {
	@Autowired private CustomerDAO service;
	

	
	@RequestMapping("/member")
	public String member(HttpSession session,Model model) {
		model.addAttribute("list",service.customer_list());
		
	
		return "/member/member";
	}
	
}	
