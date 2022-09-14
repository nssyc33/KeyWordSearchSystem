package Spring.io.groundSystem.Data.Elements;

import java.util.ArrayList;
import java.util.List;

public class LogTable {

	public static List<LogTableVo> logTable = new ArrayList<LogTableVo>();
	
	LogTable(){
		if(logTable == null) {
			logTable =  new ArrayList<LogTableVo>();
		}
	}
	
	public static List<LogTableVo> fn_logTable() {
		return logTable;
	}
	
	public static void fn_logging(LogTableVo logTableVo) {
		logTable.add(logTableVo);
	}
}
