package com.hanul.middle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import notice.NoticeVO;

@RestController
public class NoticeController {
	//one.nt = > 데이터를 한건 조회하는데 글의 제목, 글의 번호를 입력받아서 조회가 가능하게 만들면 된다.
	
	@Autowired @Qualifier ("hanul") SqlSession sql;
	
	@RequestMapping("/one.nt")
	public String one() {
		NoticeVO vo = sql.selectOne("notice.one");
		System.out.println(vo.getTitle());
		
		return "one";
	}
	
	@RequestMapping("/list.nt")
	public String list(String title) {
		List<NoticeVO> list = sql.selectList("notice.list",title);
		System.out.println(list.size());
		
		return "list";
	}
	//list.nt => 여러건 조회임.
	
}
