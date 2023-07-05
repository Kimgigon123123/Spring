package kr.co.smart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import smart.board.BoardDAO;
import smart.board.BoardVO;
import smart.common.CommonUtility;
import smart.common.PageVO;
import smart.member.MemberDAO;
import smart.member.MemberVO;

@Controller @RequestMapping("/board")
public class BoardController {
	@Autowired private BoardDAO service;
	@Autowired private MemberDAO member;
	@Autowired private BCryptPasswordEncoder pw;
	
	@Autowired private CommonUtility common;
	
	//방명록 신규저장처리 요청
	@RequestMapping("/register")
	public String register(BoardVO vo,MultipartFile file[],HttpServletRequest request) {
		//화면에서 입력한 정보를 DB에 신규저장 후 응답화면 연결 - 목록
		//첨부된 파일목록을 BoardVO에 담기
		vo.setFileList(common.attachdFiles("board", file, request));
		service.board_register(vo);
		return "redirect:list";
	}
	

	//방명록  신규입력 화면 요청
	@RequestMapping("/new")
	public String board() {
		return "board/new";
	}
	
	//방명록 목록 화면 요청
	@RequestMapping("/list")
	public String list(HttpSession session,PageVO page,Model model) {
		// 임시 로그인처리(테스트후 삭제/주석)---------
				String userid = "kis1394";
				String userpw = "pw";
				MemberVO login = member.member_info(userid);
				if( pw.matches( userpw, login.getUserpw()) ) {
					session.setAttribute("loginInfo", login);
				}
				//-------------------------------------
						
				
				model.addAttribute("page",service.baord_list(page));
				session.setAttribute("category", "bo");
				return "board/list";
	}
	
}
