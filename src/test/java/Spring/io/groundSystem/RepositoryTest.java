package Spring.io.groundSystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import Spring.io.groundSystem.Test.Data.Jpa.Account;
import Spring.io.groundSystem.Test.Data.Jpa.AccountRepository;

@RunWith(SpringRunner.class)
//@Rollback(false)
//@DataJpaTest
public class RepositoryTest {

	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void test() {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertThat("test").isNull();
	}
	
	@Test
	public void crudTest() {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
		Account ac = new Account();
		ac.setDept("IS");
		ac.setName("원빈");
		
		Account dataAc = accountRepository.save(ac);
		
		assertThat(dataAc.getId()).isNull();
	}
	
}
