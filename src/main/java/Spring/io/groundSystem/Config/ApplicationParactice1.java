package Spring.io.groundSystem.Config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationParactice1 implements ApplicationRunner, CommandLineRunner{

	@Autowired
	private ApplicationContext ac;
	
	@Autowired
	BeanFactory bf;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationRunner 를 지나갑니다.");
		String[] beans = ac.getBeanDefinitionNames();
		for (String beanName : beans) {
			System.out.println("빈 이름 : " + beanName);
		}
		
		System.out.println("확인 : " + ac.CLASSPATH_ALL_URL_PREFIX);
		System.out.println("확인 : " + ac.CLASSPATH_URL_PREFIX);
		System.out.println("확인 : " + ac.FACTORY_BEAN_PREFIX);
		System.out.println("확인 : " + ac.getStartupDate());
		System.out.println("확인 : " + fn_returnTime(ac.getStartupDate()));
	
		
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner 를 지나갑니다.");
		String[] str = new String[]{"test1","test2","test3","test4","test5","test6","test7","test8"};
		this.fn_test(str);
	}
	
	private void fn_test(String... str) {
		for (String string : str) {
			System.out.println(string);
		}
	}
	
	private String fn_returnTime(long longData) {
		Date date = new Date(longData);
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		return formatter.format(date);
	}
}
