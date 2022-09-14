package Spring.io.groundSystem.Service.Interface;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Spring.io.groundSystem.Data.Elements.LogTable;
import Spring.io.groundSystem.Data.Elements.LogTableVo;
import Spring.io.groundSystem.Data.Interface.DataInterface;


@Service
public class LogInfoService {
	
	@Autowired
	@Qualifier("memoryData")
	DataInterface data;
	
	public List<Map> fn_log() throws Exception{
		List<LogTableVo> tmplist = LogTable.fn_logTable();
		List<Map> returnList = (List)tmplist.stream()
									        .sorted((a,b)-> Long.compare((long)b.getReqDttm(),(long)a.getReqDttm()))
										    .map(a->{
										    	Map<String, Object> rMap = new HashMap<>();
											    rMap.put("fnName",  a.getFnPosition());
											    rMap.put("msg",  a.getMsg());
											    rMap.put("reqDttm",  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(a.getReqDttm()));
											    return rMap;
										    })
									        .collect(Collectors.toList());
		return returnList;
		
	}
}

