package com.my.app;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import customer.CustomerDAO;
import customer.CustomerService;
import customer.CustomerVO;

@Controller
public class CustomerController {
	@Autowired private CustomerService service;
	
	
	@RequestMapping("/list")
	public String list(HttpSession session,Model model) {
		List<CustomerVO> list = service.customer_list();
		
		model.addAttribute("list",list);
		return "/member/list";
	}
	
}
