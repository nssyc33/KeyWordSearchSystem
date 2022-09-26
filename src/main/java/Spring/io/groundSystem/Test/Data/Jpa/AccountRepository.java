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
	List<Account> finbByNameTest(@Param("name") String name);
	
	@Query(nativeQuery = true, value = "SELECT /*+ FULL(TA) */ * FROM TB_AAA TA WHERE 1 = 1")
	List<Account> finbByNameNativeQueryTest();
	
}