package Spring.io.groundSystem.Utility;

public enum MessageEnum {
	E001("필수값이 없습니다. (place)"),
	E010("데이터가 존재하지 않습니다."),
	E021("외부 API 연계 중 문제가 발생하였습니다. (KAKAO)"),
	E022("외부 API 연계 중 문제가 발생하였습니다. (NAVER)"),
	E023("외부 API 연계 중 문제가 발생하였습니다. 응답에러 NOT 200"),
	E999("시스템 당담자에게 문의 바랍니다. (010-6419-5841)"),
	S000("OK");

	private String msg;
	
	MessageEnum(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
}