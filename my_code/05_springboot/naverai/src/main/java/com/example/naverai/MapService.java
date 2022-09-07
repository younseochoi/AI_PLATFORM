package com.example.naverai;

import java.util.HashMap;

public class MapService implements NaverService {

	HashMap<String, String> map = new HashMap<String,String>();
	public MapService() {
		map.put("이름이 뭐야?", "네이버 클로버야");
		map.put("무슨일을하니?","ai 서비스관련일을해");
		map.put("멋진 일을 하는구나", "고마워");
		map.put("난 훌륭한 개발자가 될거야", "넌 할 수 있어");
		map.put("잘 자", "내꿈꿔");
		
//		무슨일을하니?–ai 서비스관련일을해 멋진 일을 하는구나 – 고마워
//				난 훌륭한 개발자가 될거야 – 넌 할 수 있어
//				잘 자 – 내꿈꿔
		
	}
	@Override
	public String test(String request) {
		String response = map.get(request);
		if(response==null||response.equals("")) {
			response = "내가 대답할 수 없는 질문이야 미안해";
		}
		return response;
	}

}
