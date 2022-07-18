package KakaoBank.io.groundSystem.Data.Elements;

import java.text.SimpleDateFormat;

public class LogTableVo {
	
	private String fnPosition;
	private String msg;
	private String reqDttm;
	
	public LogTableVo(String fnPosition, String msg, long reqDttm){
		this.fnPosition = fnPosition;
		this.msg = msg;
		this.reqDttm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reqDttm);
	}

	public String getFnPosition() {
		return fnPosition;
	}

	public String getMsg() {
		return msg;
	}

	public String getReqDttm() {
		return reqDttm;
	}

}
