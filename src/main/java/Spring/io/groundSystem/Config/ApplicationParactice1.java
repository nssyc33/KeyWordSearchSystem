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
public class ApplicationParactice1 implements ApplicationRunner{

	@Autowired
	private ApplicationContext ac;
	
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
	
	}

}
