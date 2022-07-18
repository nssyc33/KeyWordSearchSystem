package KakaoBank.io.groundSystem.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KakaoBank.io.groundSystem.Data.Elements.LogTable;

@RestController
@RequestMapping("/log")
public class LogController {

	@RequestMapping("/view")
	public Map<String, Object> fn_log(){
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("log", LogTable.fn_logTable());
		return returnMap;
	}
}
