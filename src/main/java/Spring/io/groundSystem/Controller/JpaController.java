package Spring.io.groundSystem.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Spring.io.groundSystem.ZPractice.Jpa.JpaService;

@RestController
public class JpaController {

	@Autowired
	JpaService jpaService;
	
	
	@RequestMapping("/Data")
	public Map<String, Object> fn_Data(@RequestParam Map<String, Object> inputMap){
		Map<String, Object> returnMap = new HashMap<>();
		returnMap = jpaService.fn_Service();
		return returnMap;
	}
}
