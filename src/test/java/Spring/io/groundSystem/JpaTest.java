package Spring.io.groundSystem;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import Spring.io.groundSystem.ZPractice.Jpa.Account;
import Spring.io.groundSystem.ZPractice.Jpa.AccountRepository;

@RunWith(SpringRunner.class)
@Rollback(false)
@DataJpaTest
class JpaTest {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void test_0() {
	}
	
	@Test
	public void test_1() {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertThat("test").isNotNull();
	}
	
	@Test
	public void test_2() {
		Account ac = new Account();
		ac.setDept("ITS");
		ac.setName("Seol YoungCheol");
		accountRepository.save(ac);
		assertThat(accountRepository.findAll()).size().isEqualTo(1);
	}

}
