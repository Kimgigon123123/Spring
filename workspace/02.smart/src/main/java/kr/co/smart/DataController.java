package kr.co.smart;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import smart.common.CommonUtility;

@Controller @RequestMapping("/data")
public class DataController {
	private String key
	="QdYVi2vpiC7Nk4e/68nBrCGR7ziPyZZRv7drUhvAyGXwFbEohy7IEg/RGIqmpmdQggTvMPMcJGf/d2hyN3x2zQ==";
	
	@Autowired private CommonUtility common;
	
	//약국목록 조회 요청
	@ResponseBody @RequestMapping(value="/pharmacy")
	public Object pharmacy_list(int pageNo,int rows) {
		StringBuffer url 
		= new StringBuffer("http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList");
		url.append("?ServiceKey=").append(key);
		url.append("&_type=json");
		url.append("&pageNo=").append(pageNo);
		url.append("&numOfRows=").append(rows);
		HashMap<String, Object> map = new Gson().fromJson(common.requestAPI(url.toString())
									,new TypeToken<HashMap<String,Object>>(){}.getType());
		
		return map;
	}
	

	//공공데이터 목록화면
	@RequestMapping("/list")
	public String list(HttpSession session) {
		session.setAttribute("category", "da");
		return "data/list";
	}
	
}
