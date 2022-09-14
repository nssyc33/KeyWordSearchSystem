package Spring.io.groundSystem.Data.Implement;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import Spring.io.groundSystem.Data.Elements.LogTable;
import Spring.io.groundSystem.Data.Elements.LogTableVo;
import Spring.io.groundSystem.Data.Elements.ReqHistoryTable;
import Spring.io.groundSystem.Data.Elements.ReqHistoryTableVo;
import Spring.io.groundSystem.Data.Interface.DataInterface;
//import org.springframework.transaction.annotation.Transactional;


@Async
@Service("memoryData")
//@Transactional
public class DataService implements DataInterface{

	@Override
	public void fn_logging(Map<String, Object> inputMap) {
		ReqHistoryTable.fn_logging(new ReqHistoryTableVo((String)inputMap.get("place"),LocalDate.now()));
	}
	@Override
	public void fn_logging_exception(String fnName, String msg) {
		LogTable.fn_logging(new LogTableVo(fnName, msg, System.currentTimeMillis()));
	}
}
