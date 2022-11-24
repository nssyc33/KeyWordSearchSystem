package Spring.io.groundSystem.ZPractice.Jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JpaService {

	private SaleRepository saleRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	public Map<String, Object> fn_Service(){
		List<DataTbSale> asList = (List<DataTbSale>) saleRepository.findAll();
		System.out.println("결과 건수 : "+ asList.size());
		asList.stream()
		      .forEach(System.out::println);
		return new HashMap<>();
	}
	
	public void fn_save() {
		try {
			Account ac = new Account();
			ac.setDept("ITs");
			ac.setName("start");
			accountRepository.save(ac);
//			if(true) throw new RuntimeException();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void fn_select() {
		List<Account> asList = accountRepository.findAll();
		asList.stream()
			  .forEach(a->{
				  System.out.println(a.toString());
			  });
		System.out.println("=====================================================Jpa case2");
	}
}
