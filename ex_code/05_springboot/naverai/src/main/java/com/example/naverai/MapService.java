package com.example.naverai;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service("mapservice")
/*<bean id="mapservice" class="MapService" />
MapService ampservice = new MapService();*/

public class MapService implements NaverService {
	
	HashMap<String, String> map = new HashMap();
	
	public MapService() {
		map.put("이름이 뭐니?", "네이버 클로버야");
		map.put("무슨 일을 하니?", "ai  서비스 관련 일을 해");
		map.put("멋진 일을 하는구나", "고마워");
		map.put("난 훌륭한 개발자가 될거야", "넌 할 수 있어");
		map.put("잘 자", "내꿈꿔");
	}
	
	@Override
	public String test(String request) {
		String response = map.get(request);
		if(response == null) {
			response = "응답할 수 없습니다.";
		}
		return response;
		
	}

}
