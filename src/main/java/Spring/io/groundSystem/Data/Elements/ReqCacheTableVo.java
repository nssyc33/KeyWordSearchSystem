package Spring.io.groundSystem.Data.Elements;

import java.time.LocalDate;
import java.util.List;

public class ReqCacheTableVo {
	
	private String place;
	private LocalDate reqDt;
	private List<String> detailList;
	
	public ReqCacheTableVo(String place, LocalDate reqDt, List<String> detailList){
		this.place = place;
		this.reqDt = reqDt;
		this.detailList = detailList;
	}

	public String getPlace() {
		return place;
	}

	public LocalDate getReqDt() {
		return reqDt;
	}

	public List<String> getDetailList() {
		return detailList;
	}

}
