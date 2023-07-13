package kr.co.smart;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import smart.common.CommonUtility;

@Controller @RequestMapping("/data")
public class DataController {
//	private String key
//	="QdYVi2vpiC7Nk4e/68nBrCGR7ziPyZZRv7drUhvAyGXwFbEohy7IEg/RGIqmpmdQggTvMPMcJGf/d2hyN3x2zQ==";
	
	private String key = "FPgj2NXbJw46TcGkmAfZEiYFDbxilys7KLjk3KaB7AfeJE00ZhPNM0M8unwbsI69fSmT8SNfVEimE6ZZ2U14hA%3D%3D";
	
	private String animalURL = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/";


	
	@Autowired private CommonUtility common;
	//유기동물 시군구조회 요청
		@RequestMapping("/animal/sigungu")
		public String animal_sigungu(Model model, String sido) {
			StringBuffer url = new StringBuffer( animalURL );
			url.append("sigungu?serviceKey=").append(key);
			url.append( "&_type=json" );
			url.append( "&upr_cd=" ).append( sido );
			model.addAttribute("list", common.requestAPIResultInfo(url));
			return "data/animal/sigungu";
		}
	
	
	//유기동물 시도조회 요청
	@RequestMapping("/animal/sido")
	public String animal_sido(Model model) {
		StringBuffer url = new StringBuffer( animalURL);
		url.append("sido?serviceKey=").append(key);
		url.append("&_type=json");
		url.append("&numOfRows=30");
		model.addAttribute("list",common.requestAPIResultInfo(url));
		return "data/animal/sido";
	}
	
	
	
	//유기동물 조회 요청
	//jsp에서 보낸 json 파라메터는 바로 데이터객체에 담기지 않는다.
	@RequestMapping("/animal/list")
	public Object animal_list(@RequestBody HashMap<String, Object> map, Model model) {
		StringBuffer url = new StringBuffer( animalURL );
		url.append( "abandonmentPublic?serviceKey=" ).append( key );
		url.append( "&_type=json" );
		url.append( "&pageNo=" ).append( map.get("curPage") );
		url.append( "&numOfRows=" ).append( map.get("pageList") );
		url.append("&upr_cd=").append(map.get("sido"));
		model.addAttribute("list", common.requestAPIResultInfo( url.toString() ) );
		return "data/animal/animal_list";
	}
	
	
	
//	@RequestMapping("/animal/list")
//	public Object animal_list(int pageNo,int rows,Model model) {
//		StringBuffer url = new StringBuffer(animalURL);
//		url.append("abandonmentPublic?serviceKey=").append(key);
//		url.append("&_type=json");
//		url.append("&pageNo=").append(pageNo);
//		url.append("&numOfRows=").append(rows);
//		model.addAttribute("list", common.requestAPIResultInfo(url.toString()));
//		
//		return "data/animal/animal_list";
//		
//	}
	
//	public Object animal_list(int pageNo,int rows) {
//		StringBuffer url = new StringBuffer(animalURL);
//		url.append("abandonmentPublic?serviceKey=").append(key);
//		url.append("&_type=json");
//		url.append("&pageNo=").append(pageNo);
//		url.append("&numOfRows=").append(rows);
//		return new Gson().fromJson(common.requestAPI(url.toString()), new TypeToken<HashMap<String, Object>>(){}.getType());
//		
//	}
//	
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
