package customer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;



public class CustomerDAO implements CustomerService {
	public SqlSession sql;
	
	
	@Override
	public List<CustomerVO> customer_list() {
		return sql.selectList("customer.list");
	}

}
