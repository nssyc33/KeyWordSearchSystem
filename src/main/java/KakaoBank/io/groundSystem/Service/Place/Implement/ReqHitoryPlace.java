package KakaoBank.io.groundSystem.Service.Place.Implement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import KakaoBank.io.groundSystem.Data.Elements.ReqHistoryTable;
import KakaoBank.io.groundSystem.Data.Elements.ReqHistoryTableVo;
import KakaoBank.io.groundSystem.Exception.ProcessException;
import KakaoBank.io.groundSystem.Service.Interface.ReqHitoryInterface;
import KakaoBank.io.groundSystem.Utility.MessageEnum;

@Service("placeHistory")
public class ReqHitoryPlace implements ReqHitoryInterface{

	@Override
	public List fn_hitory() throws Exception {
		List<ReqHistoryTableVo> logList = ReqHistoryTable.fn_historyTable();
		List rList = new ArrayList();
		Map<String, Long> returnMap = logList.stream()
				                             .collect(Collectors.groupingBy(ReqHistoryTableVo::getPlace, Collectors.counting()));
		List<String> iList = new ArrayList(returnMap.keySet());
		List<Counts> asList = new ArrayList();
		for (String key : iList) {
			asList.add(new Counts(key, (Long)returnMap.get(key)));
		}
		if(asList.size() == 0) {
			return rList;
		}
		rList = asList.stream()
		              .sorted(Comparator.comparing(Counts::getCounts).reversed()) 
		              .collect(Collectors.toList());
		return rList;
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
