package com.hanul.middle;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired @Qualifier ("hanul") SqlSession sql;
	
	@RequestMapping(value=" / ")
	public String home() {
		
		
		/*
		 * <bean id="dbcpHanul" class="org.apache.commons.dbcp2.BasicDataSource">
		 * <property name="driverClassName" value="${oracle.driver}"/> <property
		 * name="url" value="${oracle.url}"/> <property name="username"
		 * value="${hanul.username}"/> <property name="password"
		 * value="${hanul.password}"/> </bean>
		 */
		int result = sql.selectOne("test.dual");
		System.out.println(result);
	
	
	return "home";
		
		
	}
	
}
