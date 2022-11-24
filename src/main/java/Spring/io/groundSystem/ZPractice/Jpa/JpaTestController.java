package Spring.io.groundSystem.ZPractice.Jpa;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaTestController {

	@Autowired
	JpaService jpaService;
	
	@RequestMapping("/jpaSave")
	public HashMap fn_save() {
		jpaService.fn_save();
		return new HashMap();
	}
	
	@RequestMapping("/jpaSelect")
	public HashMap fn_select() {
		jpaService.fn_select();
		return new HashMap();
	}

}
