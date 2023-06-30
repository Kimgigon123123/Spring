package smart.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import smart.common.PageVO;

//@Component를 구분 - 저장소(DB): Repository,서비스: Service, 컨트롤러: Controller 
//화면연결 응답이 아니라 이 처리 자체가 응답: @ResponseBody : ajax 통신요청 결과
//요청url에 파라미터로 데이터를 전달: ajax 통신시 json 데이터를 파라미터로 전달시 @RequestBody
@Repository
public class NoticeDAO implements NoticeService{
	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	
	@Override
	public int notice_regist(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sql.insert("notice.insert",vo);
	}

	@Override
	public List<NoticeVO> notice_list() {
		
		return sql.selectList("notice.list");
	}

	@Override
	public NoticeVO notice_info(int id) {
		// TODO Auto-generated method stub
		return sql.selectOne("notice.info",id);
	}

	@Override
	public int notice_update(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sql.update("notice.update",vo);
	}

	@Override
	public int notice_delete(int id) {
		// TODO Auto-generated method stub
		return sql.delete("notice.delete",id);
	}

	@Override
	public int notice_read(int id) {
		// TODO Auto-generated method stub
		return sql.update("notice.read",id);
	}

	@Override
	public PageVO notice_list(PageVO page) {
		page.setTotalList(sql.selectOne("notice.totalList",page));
		page.setList(sql.selectList("notice.list",page));
		
		return page;
	}//해당 페이지의 공지목록 조회

	@Override
	public int notice_reply_regist(NoticeVO vo) {
		return sql.insert("notice.replyRegister",vo);
	}
	
	
	
	

}
