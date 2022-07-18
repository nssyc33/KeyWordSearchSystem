package KakaoBank.io.groundSystem.Service.Place.Implement;


import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import KakaoBank.io.groundSystem.Data.Elements.LogTable;
import KakaoBank.io.groundSystem.Data.Elements.LogTableVo;
import KakaoBank.io.groundSystem.Exception.ProcessException;
import KakaoBank.io.groundSystem.Service.Interface.HttpApiInterface;
import KakaoBank.io.groundSystem.Utility.MessageEnum;

@Service("NaverApi")
public class HttpNaver implements HttpApiInterface {
	
	@Value("${naverKey}")
	private String naverKey;

	@Value("${naverPwd}")
	private String naverPwd;
	
	public Map fn_get_data(Map inputMap) throws Exception{
		Map resultMap = new HashMap();
		try(CloseableHttpClient httpClient = HttpClientBuilder.create()
											.setMaxConnTotal(100)
											.setMaxConnPerRoute(100)
											.build();){
			HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
			factory.setConnectTimeout(1000*20);
			factory.setReadTimeout(1000*20);
			factory.setHttpClient(httpClient);
			
			RestTemplate restTemplate = new RestTemplate(factory);
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-Naver-Client-Id", naverKey);
			headers.set("X-Naver-Client-Secret", naverPwd);
			HttpEntity httpEntity = new HttpEntity(headers);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("https://openapi.naver.com/v1/search/local")
																  .queryParam("display", 5)
																  .queryParam("query", (String)inputMap.get("place"));
			URI encodedUri =  uriBuilder.build().encode().toUri();
			ResponseEntity<Map> response = restTemplate.exchange(encodedUri,HttpMethod.GET,httpEntity,Map.class);
			if(response.getStatusCodeValue() != 200) {
				throw new Exception(MessageEnum.E023.getMsg());
			}
			resultMap = fn_data_custum((Map)response.getBody());
		}catch(Exception e) {
			LogTable.fn_logging(new LogTableVo("fn_get_data", e.getMessage(), System.currentTimeMillis()));
			throw new ProcessException(MessageEnum.E022, MessageEnum.E022.getMsg());
		}
		return resultMap;
	}
	
	private Map fn_data_custum(Map intermediateMap) {
		Map returnMap = new HashMap();
		List dataList = (List) ((List)intermediateMap.get("items"))
						.stream()
						.map(x->{
							Map tempMap = (Map)x;
							tempMap.remove("link");
							tempMap.remove("category");
							tempMap.remove("description");
							tempMap.remove("telephone");
							tempMap.remove("roadAddress");
							tempMap.remove("link");
							tempMap.remove("mapx");
							tempMap.remove("mapy");
							tempMap.put("place_name", new String(((String)tempMap.get("title")).replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")));
							tempMap.put("address_name", new String(((String)tempMap.get("address")).replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")));
							tempMap.remove("title");
							tempMap.remove("address");
							return tempMap;
						})
						.collect(Collectors.toList());
		returnMap.put("data", dataList);
		return returnMap;
	}
}
