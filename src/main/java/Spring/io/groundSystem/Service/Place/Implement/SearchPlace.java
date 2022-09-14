package Spring.io.groundSystem.Service.Place.Implement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Spring.io.groundSystem.Data.Elements.ReqCacheTable;
import Spring.io.groundSystem.Data.Elements.ReqCacheTableVo;
import Spring.io.groundSystem.Exception.ValidationException;
import Spring.io.groundSystem.Service.Interface.HttpApiInterface;
import Spring.io.groundSystem.Service.Interface.SearchInterface;
import Spring.io.groundSystem.Utility.MessageEnum;
import Spring.io.groundSystem.Utility.Utilitiy;


@Service("searchPlace")
public class SearchPlace implements SearchInterface{
	
	@Autowired
	@Qualifier("kakaoApi")
	HttpApiInterface kakaoApi;

	@Autowired
	@Qualifier("NaverApi")
	HttpApiInterface naverApi;
	
	@Autowired
	ValidationService validationService;
	
	@Override
	public void fn_validation(Map inputMap) throws Exception {
		if("".equals(Utilitiy.NVLS(inputMap.get("place")))){
			throw new ValidationException(MessageEnum.E001, MessageEnum.E001.getMsg());
		}	
	}
	
	@Override
	public List<String> fn_get_search_data(Map inputMap) throws Exception {
		List<String> resultList = this.fn_cacheData((String)inputMap.get("place"),LocalDate.now());
		if(resultList.size() == 0) {
			resultList = this.fn_mergeForKakao(kakaoApi.fn_get_data(inputMap), naverApi.fn_get_data(inputMap));
			ReqCacheTable.fn_caching(new ReqCacheTableVo((String)inputMap.get("place"),LocalDate.now(),resultList));
		}
		return resultList;
	}
	
	private List<String> fn_cacheData(String place, LocalDate nowDt){
		List<String> resCacheTable = new ArrayList<>();
		List<ReqCacheTableVo> reqCacheTable = ReqCacheTable.fn_cacheTable();
		for (ReqCacheTableVo reqCacheTableVo : reqCacheTable) {
			if(place.equals(reqCacheTableVo.getPlace()) && nowDt.equals(reqCacheTableVo.getReqDt())) {
				resCacheTable = reqCacheTableVo.getDetailList();
			}
		}
		return resCacheTable;
	}
	
	private List<String> fn_mergeForKakao(Map kakaoMap, Map naverMap) {
		List<String> outputList = new ArrayList();
		List<String> tempTotalList = new ArrayList();
		List<Map> tempMapTotalList = new ArrayList();
		List<Map> kakaoList = (List)(kakaoMap).get("data");
		List<String> tempKakaoList = new ArrayList();
		for (Map listMap : kakaoList) {
			tempKakaoList.add((String)listMap.get("address_name"));
		}
		
		List<Map> naverList = (List)(naverMap).get("data");
		List<String> tempNaverList = new ArrayList<>();
		for (Map listMap : naverList) {
			tempNaverList.add((String)listMap.get("address_name"));
		}
		tempMapTotalList.addAll(kakaoList);
		tempMapTotalList.addAll(naverList);
		tempTotalList.addAll(tempKakaoList);
		tempTotalList.addAll(tempNaverList);
		
		//----------------------------------------------------------------------------------//
		Set<String> totalSet = new LinkedHashSet<>(tempTotalList);
		List<String> setList = new ArrayList<>(totalSet);

		int setSize = setList.size();
		setSize = setSize > 10 ? 10 : setSize;
				
		List<String> addressList = new ArrayList<>();
		for (int i=0; i<setSize; i++) {
			addressList.add((String)setList.get(i));
		}
		
		int returnListSize = addressList.size();
		int passCnt = 0;
		for (int i=0; i<returnListSize; i++) {
			if(!tempKakaoList.contains((String)addressList.get(i-passCnt))) {
				addressList.add(addressList.get(i-passCnt));
				addressList.remove(i-passCnt);
				passCnt++;
			}
		}
		//----------------------------------------------------------------------------------//
		for(String addressName : addressList) {
			for(Map tempMap : tempMapTotalList) {
				if(addressName.equals((String)tempMap.get("address_name"))){
					outputList.add((String)tempMap.get("place_name"));
					break;
				}
			}
		}
		return outputList;
	}
}
