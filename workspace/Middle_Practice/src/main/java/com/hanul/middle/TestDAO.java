package com.hanul.middle;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;



@Repository
public class TestDAO {
	
	private SqlSession sql;
	
	public int test(TestVO vo) {
		// TODO Auto-generated method stub
		return sql.selectOne("test.test",vo);

}
}
