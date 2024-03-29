package Spring.io.groundSystem.Config;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import Spring.io.groundSystem.ZPractice.Jpa.Account;
import Spring.io.groundSystem.ZPractice.Jpa.AccountRepository;
import Spring.io.groundSystem.ZPractice.Jpa.SaleRepository;
import Spring.io.groundSystem.ZPractice.Jpa.MemberShip.Member;
import Spring.io.groundSystem.ZPractice.Jpa.MemberShip.MemberRepository;

@Component
@Transactional
public class ApplicationPractice2Jpa implements ApplicationRunner{

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.fn_jpaCase0();
//		this.fn_jpaCase1();
		this.fn_jpaCase2();
//		this.fn_jpaCase3();
//		this.fn_jpaCase4();

		this.fn_jpaCase_memberExist();
		this.fn_jpaCase_memberSave();
		this.fn_jpaCase_memberExist();
		this.fn_jpaCase_memberGet();
		
	}
	
	private void fn_jpaCase0() {
		accountRepository.deleteAll();
	}
	
	private void fn_jpaCase1() {
		System.out.println("=====================================================Jpa case1");
		Account ac = new Account();
		ac.setDept("IT");
		ac.setName("youngCheol");
		Session ss = entityManager.unwrap(Session.class);
		ss.save(ac);
		System.out.println("=====================================================Jpa case1");
	}
	
	private void fn_jpaCase2() {
		System.out.println("=====================================================Jpa case2");
		Account ac = new Account();
		ac.setDept("IT");
		ac.setName("youngCheol");
		accountRepository.save(ac);
		
		List<Account> asList = accountRepository.findAll();
		asList.stream()
			  .forEach(a->{
				  System.out.println(a.getDept() + " : " + a.getName());
			  });
		System.out.println("=====================================================Jpa case2");
	}
	
//	private void fn_jpaCase3() {
//		System.out.println("=====================================================Jpa case3");
//		List<Account> asList = accountRepository.finbByNameTest("youngCheol");
//		asList.stream()
//			  .forEach(a->{
//				  System.out.println(a.getDept() + " : " + a.getName());
//			  });
//		System.out.println("=====================================================Jpa case3");
//	}
//	
//	private void fn_jpaCase4() {
//		System.out.println("=====================================================Jpa case4");
//		List<Account> asList = accountRepository.finbByNameNativeQueryTest();
//		asList.stream()
//			  .forEach(a->{
//				  System.out.println(a.getDept() + " : " + a.getName());
//			  });
//		System.out.println("=====================================================Jpa case4");
//	}
	
	private void fn_jpaCase_memberExist() {
		System.out.println("=====================================================Jpa case5");
		List<Member> asList = (List<Member>) memberRepository.findAll();
		System.out.println("==================================");
		System.out.println("크기 : "+asList.size());
		System.out.println("==================================");
		System.out.println("=====================================================Jpa case5");
	}
	private void fn_jpaCase_memberSave() {
		Member mb = new Member();
		mb.setId(123456789);
		mb.setBarCd("1234567890");
		memberRepository.save(mb);
	}
	
	private void fn_jpaCase_memberGet() {
		List<Member> asList = memberRepository.findAllById(123456789);
		System.out.println(asList.size());
	}
}
