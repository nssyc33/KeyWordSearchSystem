package Spring.io.groundSystem.Test.Data.Jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends CrudRepository<DataTbSale, Integer>{
	
	List<DataTbSale> findAllByRn(Integer rn);
}
