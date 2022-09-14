package Spring.io.groundSystem.Data.Elements;

import java.util.ArrayList;
import java.util.List;

public class ReqHistoryTable {

	public static List<ReqHistoryTableVo> reqHistoryTable = new ArrayList<ReqHistoryTableVo>();
	
	ReqHistoryTable(){
		if(reqHistoryTable == null) {
			reqHistoryTable =  new ArrayList<ReqHistoryTableVo>();
		}
	}
	
	public static List<ReqHistoryTableVo> fn_historyTable() {
		return reqHistoryTable;
	}
	
	public static void fn_logging(ReqHistoryTableVo reqHistoryTableVo) {
		reqHistoryTable.add(reqHistoryTableVo);
	}
}
