package KakaoBank.io.groundSystem.Data.Elements;

import java.text.SimpleDateFormat;

public class LogTableVo {
	
	private String fnPosition;
	private String msg;
	private long reqDttm;
	
	public LogTableVo(String fnPosition, String msg, long reqDttm){
		this.fnPosition = fnPosition;
		this.msg = msg;
		this.reqDttm = reqDttm;
	}

	public String getFnPosition() {
		return fnPosition;
	}

	public String getMsg() {
		return msg;
	}

	public long getReqDttm() {
		return reqDttm;
	}

}
