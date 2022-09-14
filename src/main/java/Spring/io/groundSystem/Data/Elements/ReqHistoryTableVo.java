package Spring.io.groundSystem.Data.Elements;

import java.time.LocalDate;

public class ReqHistoryTableVo {
	
	private String place;
	private LocalDate reqDt;
	
	public ReqHistoryTableVo(String place, LocalDate reqDt){
		this.place = place;
		this.reqDt = reqDt;
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public LocalDate getReqDttm() {
		return reqDt;
	}
	public void setReqDttm(LocalDate reqDt) {
		this.reqDt = reqDt;
	}
	
	

}
