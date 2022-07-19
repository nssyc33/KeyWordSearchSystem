package KakaoBank.io.groundSystem.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KakaoBank.io.groundSystem.Exception.ProcessException;
import KakaoBank.io.groundSystem.Exception.ValidationException;
import KakaoBank.io.groundSystem.Service.SearchInfoService;
import KakaoBank.io.groundSystem.Service.Place.ValidationService;
import KakaoBank.io.groundSystem.Service.HistoryInfoService;
import KakaoBank.io.groundSystem.Utility.MessageEnum;

@RestController
@RequestMapping("/search/place")
public class SearchController {

	@Autowired
	SearchInfoService searchInfoService;
	
	@Autowired
	HistoryInfoService historyInfoService;
	
	@GetMapping("/info")
	public Map<String, Object> fn_placeInfo_getMethod(@RequestParam Map<String, Object> inputMap) {
		Map<String, Object> returnMap = new HashMap<>();
		try {
			returnMap = searchInfoService.fn_mainService(inputMap);
			if(returnMap.get("data") != null) {
				returnMap.put("resultCd", MessageEnum.S000);
				returnMap.put("resultMsg", MessageEnum.S000.getMsg());
			}else {
				returnMap.put("resultCd", MessageEnum.E010);
				returnMap.put("resultMsg", MessageEnum.E010.getMsg());
			}
		}catch(ValidationException e) {
			returnMap.put("resultCd", e.getExceptionCd());
			returnMap.put("resultMsg", e.getExceptionMsg());
		}catch(ProcessException e) {
			returnMap.put("resultCd", e.getExceptionCd());
			returnMap.put("resultMsg", e.getExceptionMsg());
		}catch(Exception e) {
			returnMap.put("resultCd", MessageEnum.E999);
			returnMap.put("resultMsg", MessageEnum.E999.getMsg());
		}finally {
			return returnMap;
		}
	}
	
	@PostMapping("/info")
	public Map fn_placeInfo_postMethod(@RequestBody Map<String, Object> inputMap) {
		Map<String, Object> returnMap = new HashMap<>();
		try {
			returnMap = searchInfoService.fn_mainService(inputMap);
			if(returnMap.get("data") != null) {
				returnMap.put("resultCd", MessageEnum.S000);
				returnMap.put("resultMsg", MessageEnum.S000.getMsg());
			}else {
				returnMap.put("resultCd", MessageEnum.E010);
				returnMap.put("resultMsg", MessageEnum.E010.getMsg());
			}
		}catch(ValidationException e) {
			returnMap.put("resultCd", e.getExceptionCd());
			returnMap.put("resultMsg", e.getExceptionMsg());
		}catch(ProcessException e) {
			returnMap.put("resultCd", e.getExceptionCd());
			returnMap.put("resultMsg", e.getExceptionMsg());
		}catch(Exception e) {
			returnMap.put("resultCd", MessageEnum.E999);
			returnMap.put("resultMsg", MessageEnum.E999.getMsg());
		}finally {
			return returnMap;
		}
		
	}
	
	@GetMapping("/history")
	public Map fn_placeInfo_history(@RequestParam Map inputMap) {
		Map<String, Object> returnMap = new HashMap<>();
		try {
			returnMap = historyInfoService.fn_history();
			if(returnMap.get("data") != null) {
				returnMap.put("resultCd", MessageEnum.S000);
				returnMap.put("resultMsg", MessageEnum.S000.getMsg());
			}else {
				returnMap.put("resultCd", MessageEnum.E010);
				returnMap.put("resultMsg", MessageEnum.E010.getMsg());
			}
		}catch(ProcessException e) {
			returnMap.put("resultCd", e.getExceptionCd());
			returnMap.put("resultMsg", e.getExceptionMsg());
		}catch(Exception e) {
			returnMap.put("resultCd", MessageEnum.E999);
			returnMap.put("resultMsg", MessageEnum.E999.getMsg());
		}finally {
			return returnMap;
		}
	}
	
}