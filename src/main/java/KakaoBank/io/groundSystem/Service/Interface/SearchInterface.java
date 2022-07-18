package KakaoBank.io.groundSystem.Service.Interface;

import java.util.List;
import java.util.Map;

public interface SearchInterface {
	
	public void fn_validation(Map inputMap) throws Exception;
	
	public List<String> fn_get_search_data(Map inputMap) throws Exception;
}
