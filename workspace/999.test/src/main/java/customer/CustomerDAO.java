package customer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDAO implements CustomerService {
	
	
	@Override
	public List<CustomerVO> customer_list() {
		
		return null;
	}

}
