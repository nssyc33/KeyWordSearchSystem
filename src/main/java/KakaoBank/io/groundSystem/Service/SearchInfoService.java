package KakaoBank.io.groundSystem.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import KakaoBank.io.groundSystem.Data.Interface.DataInterface;
import KakaoBank.io.groundSystem.Service.Interface.SearchInterface;

@Service
public class SearchInfoService {

	@Autowired
	@Qualifier("searchPlace")
	SearchInterface search;
	
	@Autowired
	@Qualifier("memoryData")
	DataInterface data;
	
	public Map<String, Object> fn_mainService(Map<String, Object> inputMap) throws Exception{
		Map<String, Object> returnMap = new HashMap<>();
		try {
			search.fn_validation(inputMap);
			data.fn_logging(inputMap);
			returnMap.put("data", search.fn_get_search_data(inputMap));
			return returnMap;
		}catch(Exception e) {
			data.fn_logging_exception("fn_mainService", e.getMessage());
			throw e;
		}
	}
}

