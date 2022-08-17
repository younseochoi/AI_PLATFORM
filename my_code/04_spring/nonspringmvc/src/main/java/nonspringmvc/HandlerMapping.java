package nonspringmvc;

import java.util.HashMap;

public class HandlerMapping {
	//생성자 1개 , localhost:8080/nonspringmvc/a
	HashMap<String, Controller> mappings = new HashMap<String, Controller>();
	public HandlerMapping() {
		mappings.put("hello", new HelloController());
		mappings.put("list", new ListController());
	}
	
	//getController 메소드
	Controller getController(String key) {
		System.out.println("키 = "+key);
		return mappings.get(key);
	}
}
