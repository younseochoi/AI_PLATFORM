package nonspringmvc;

import java.util.HashMap;

public class HandlerMapping {
	//생성자 . http://loalhost:8080/nonsrpingmvc/hello
	HashMap<String, Controller> mappings ;
	HandlerMapping(){
		mappings = new HashMap<String, Controller>();
		mappings.put("hello", new HelloController());
		mappings.put("list",new ListController());
		//mappings.put("a", new AController());
	}
	Controller getController(String key){
		System.out.println("키="+key);
		return mappings.get(key);
	}
}
