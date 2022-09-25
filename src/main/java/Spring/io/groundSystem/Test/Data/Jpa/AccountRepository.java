package Spring.io.groundSystem.Test.Data.Jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	List<Account> findAllById(Integer id);
	
	@Query("select u from Account u where u.name = :name")
	List<Account> finbByName(@Param("name") String name);

}