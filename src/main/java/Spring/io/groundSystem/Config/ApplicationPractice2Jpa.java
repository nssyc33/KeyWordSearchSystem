package Spring.io.groundSystem.Config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import Spring.io.groundSystem.Test.Data.Account;

@Component
@Transactional
public class ApplicationPractice2Jpa implements ApplicationRunner{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=====================================================Jpa Test Start");
		Account ac = new Account();
		ac.setDept("IT");
		ac.setName("youngCheol");
		
		Session ss = entityManager.unwrap(Session.class);
		ss.save(ac);
		System.out.println("=====================================================Jpa Test End");
	}
}
