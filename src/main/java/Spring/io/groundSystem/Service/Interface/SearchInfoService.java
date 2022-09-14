package Spring.io.groundSystem.Service.Interface;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Spring.io.groundSystem.Data.Interface.DataInterface;
import Spring.io.groundSystem.Exception.ProcessException;
import Spring.io.groundSystem.Exception.ValidationException;


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
			if(true) {
				throw new Exception("예외를 발생하였습니다.");
			}
			return returnMap;
		}catch(ValidationException e) {
			data.fn_logging_exception("fn_mainService", e.getExceptionMsg());
			throw e;
		}catch(ProcessException e) {
			throw e;
		}catch(Exception e) {
			data.fn_logging_exception("fn_mainService", e.getMessage());
			throw e;
		}
	}
}

