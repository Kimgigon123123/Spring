package customer;

import java.util.List;

import org.springframework.stereotype.Service;


public interface CustomerService {

	
	//목록 조회
	List<CustomerVO> customer_list();
	
	
	
}
