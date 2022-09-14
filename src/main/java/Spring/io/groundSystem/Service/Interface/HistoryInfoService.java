package Spring.io.groundSystem.Service.Interface;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Spring.io.groundSystem.Data.Interface.DataInterface;


@Service
public class HistoryInfoService {

	@Autowired
	@Qualifier("placeHistory")
	ReqHitoryInterface reqHistoryPlace;
	
	@Autowired
	@Qualifier("memoryData")
	DataInterface data;
	
	public Map<String, Object> fn_history() throws Exception{
		Map<String, Object> returnMap = new HashMap<>();
		try {
			returnMap.put("data", reqHistoryPlace.fn_hitory());
		}catch(Exception e) {
			data.fn_logging_exception("fn_history", e.getMessage());
			throw e;
		}
		return returnMap;
	}
	
	private class Counts {
		private final String keys;
		private final Long counts;
		public Counts(final String keys, final Long counts) {
			this.keys = keys;
			this.counts = counts;
		}

		public String getKeys() {
			return keys;
		}

		public Long getCounts() {
			return counts;
		}
	}
	
}
