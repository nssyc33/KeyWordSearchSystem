package KakaoBank.io.groundSystem.Exception;

import KakaoBank.io.groundSystem.Utility.MessageEnum;

public class ValidationException extends Exception{

	private MessageEnum exceptionCd;
	private String exceptionMsg;	
	
	public ValidationException(MessageEnum exceptionCd, String exceptionMsg) {
		this.exceptionCd = exceptionCd;
		this.exceptionMsg = exceptionMsg;
	}

	public MessageEnum getExceptionCd() {
		return exceptionCd;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}
}
