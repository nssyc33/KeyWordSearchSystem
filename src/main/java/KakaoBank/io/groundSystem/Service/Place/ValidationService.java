package KakaoBank.io.groundSystem.Service.Place;

import java.util.Map;

import org.springframework.stereotype.Service;

import KakaoBank.io.groundSystem.Data.Elements.LogTable;
import KakaoBank.io.groundSystem.Data.Elements.LogTableVo;
import KakaoBank.io.groundSystem.Exception.ValidationException;
import KakaoBank.io.groundSystem.Utility.MessageEnum;
import KakaoBank.io.groundSystem.Utility.Utilitiy;

@Service
public class ValidationService {

	public void fn_validation(Map inputMap) throws ValidationException {
		if("".equals(Utilitiy.NVLS(inputMap.get("place")))){
			throw new ValidationException(MessageEnum.E001, MessageEnum.E001.getMsg());
		}
	}
}
