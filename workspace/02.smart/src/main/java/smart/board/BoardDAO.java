package smart.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import smart.common.PageVO;

@Repository
public class BoardDAO implements BoardService {
	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	
	@Override
	public int board_register(BoardVO vo) {
		//방명록 정보 저장 + 첨부파일정보 저장
		int insert = sql.insert("board.register",vo);
		if(insert == 1 && vo.getFileList() != null) {
			sql.insert("board.fileRegister",vo); 
		}
		return insert;
	}

	@Override
	public PageVO baord_list(PageVO page) {
		//건수조회
		page.setTotalList(sql.selectOne("board.totalList",page));
		page.setList(sql.selectList("board.list",page));
		return page;
	}

	@Override
	public BoardVO board_info(int id) {
		// TODO Auto-generated method stub
		return sql.selectOne("board.info",id);
	}

	@Override
	public int board_update(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board_read(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board_delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
