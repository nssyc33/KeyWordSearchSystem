package Spring.io.groundSystem.Test.Data.Jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class JpaService {

	private SaleRepository saleRepository;
	
	public Map<String, Object> fn_Service(){
		List<DataTbSale> asList = saleRepository.findAllByRn(1);
		System.out.println("결과 건수 : "+ asList.size());
		asList.stream()
		      .forEach(System.out::println);
		return new HashMap<>();
	}
}
