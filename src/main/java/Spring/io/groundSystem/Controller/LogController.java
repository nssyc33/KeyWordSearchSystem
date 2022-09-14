package Spring.io.groundSystem.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Spring.io.groundSystem.Service.Interface.LogInfoService;
import Spring.io.groundSystem.Utility.MessageEnum;


@RestController
@RequestMapping("/log")
public class LogController {

	@Autowired 
	LogInfoService logInfoService;
	
	@RequestMapping("/view")
	public Map<String, Object> fn_log() throws Exception{
		Map<String, Object> returnMap = new HashMap<>();
		List<Map> logList = logInfoService.fn_log();
		try {
			if(logList == null || logList.size() == 0) {
				returnMap.put("resultCd", MessageEnum.E010);
				returnMap.put("resultMsg", MessageEnum.E010.getMsg());
			}else {
				returnMap.put("data", logInfoService.fn_log());
				returnMap.put("resultCd", MessageEnum.S000);
				returnMap.put("resultMsg", MessageEnum.S000.getMsg());
			}
		}catch(Exception e) {
			returnMap.put("resultCd", MessageEnum.E999);
			returnMap.put("resultMsg", MessageEnum.E999.getMsg());
		}
		return returnMap;
	}
	
	@PostConstruct
	public void fn_test() {
		System.out.println("빈파일 생성이 되었습니다.");
	}
	
	
}
