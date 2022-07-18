package KakaoBank.io.groundSystem.Utility;

public class Utilitiy {
	
	public static String NVLS(Object obj) {
		if(obj == null) {
			return "";
		}else {
			return obj.toString();
		}
	}
}
