package Spring.io.groundSystem.Data.Elements;

import java.util.ArrayList;
import java.util.List;

public class ReqCacheTable {

	public static List<ReqCacheTableVo> reqCacheTable = new ArrayList<ReqCacheTableVo>();
	
	ReqCacheTable(){
		if(reqCacheTable == null) {
			reqCacheTable =  new ArrayList<ReqCacheTableVo>();
		}
	}
	
	public static List<ReqCacheTableVo> fn_cacheTable() {
		return reqCacheTable;
	}
	
	public static void fn_caching(ReqCacheTableVo reqCacheTableMasterVo) {
		reqCacheTable.add(reqCacheTableMasterVo);
	}
}
