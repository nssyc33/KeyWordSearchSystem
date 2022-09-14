package Spring.io.groundSystem.Service.Place.Implement;

import java.util.Map;

import org.springframework.stereotype.Service;

import Spring.io.groundSystem.Exception.ValidationException;
import Spring.io.groundSystem.Utility.MessageEnum;
import Spring.io.groundSystem.Utility.Utilitiy;



@Service
public class ValidationService {

	public void fn_validation(Map inputMap) throws ValidationException {
		if("".equals(Utilitiy.NVLS(inputMap.get("place")))){
			throw new ValidationException(MessageEnum.E001, MessageEnum.E001.getMsg());
		}
	}
}
