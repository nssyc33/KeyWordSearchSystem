package Spring.io.groundSystem.Data.Interface;

import java.util.Map;

public interface DataInterface {

	public void fn_logging(Map<String, Object> map);
	
	public void fn_logging_exception(String fnName, String msg);
	
}
