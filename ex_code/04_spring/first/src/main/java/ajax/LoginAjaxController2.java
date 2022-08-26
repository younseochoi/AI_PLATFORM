package ajax;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import board.spring.mybatis.MemberDTO;
import board.spring.mybatis.MemberService;

@Controller
public class LoginAjaxController2 {
	@Qualifier("service")
	@Autowired
	MemberService service;
	
	@GetMapping("/loginajax2")
	public String loginform() {
		return "ajax/loginform2";
	}
	//@ResponseBody 
	@PostMapping(value="/loginajax2" , produces = {"application/json;charset=utf-8"})
	public @ResponseBody MemberDTO loginresult(MemberDTO dto) {
		// db member테이블 해당 id 있으면 그 정보를 가져와서 MemberDTO 리턴
		if(dto.getPassword() == 1234 && dto.getId().equals("ajax")) {
			dto.setName("이동기");
			dto.setPhone("01099990000");
			dto.setEmail("dong@a.co.kr");
			dto.setRegdate("2022-08-25");
		}
		return dto;  //MemberDTO = JSON 자동변환 라이브러리
		// "{\"id\": \"" + dto.getId() + "\" , "password" : dto.getPassword}"
		//pom.xml ,
		
	}
	
	@ResponseBody
	@RequestMapping("/memberlistajax")
	public List<MemberDTO> memberlist(){
		List<MemberDTO> memberlist = service.memberlist();
		return memberlist;
		/* "[{\"id\": \"" + dto.getId() + "\" , "password" :....},
		 * {\"id\": \"" + dto.getId() + "\" , "password" :....},
		 * {\"id\": \"" + dto.getId() + "\" , "password" :....},
		 * ...]
		 *    */
		
	}
	
	@ResponseBody
	@RequestMapping("/memberpasswordajax")
	public String memberpassword(String id){
		List<MemberDTO> list = service.onemember(id);// id pk 변경 상태이므로 갯수 1개 리턴
		String password = String.valueOf(list.get(0).getPassword());
		password = password.substring(0, 2)  + "*".repeat(password.length()-2); 
		return  "{\"id\" : \"" + id + "\" , \"password\" : \"" + password + "\"}";
		
	}
	
	@RequestMapping("/memberpasswordajax2/{id}")
	public @ResponseBody String memberpassword2(@PathVariable("id") String id){
		List<MemberDTO> list = service.onemember(id);// id pk 변경 상태이므로 갯수 1개 리턴
		String password = String.valueOf(list.get(0).getPassword());
		password = password.substring(0, 1)  + "*".repeat(password.length()-1); 
		return  "{\"id\" : \"" + id + "\" , \"password\" : \"" + password + "\"}";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadajax", produces = {"application/json;charset=utf-8"})
	public String uploadajax(MultipartFile uploadfile) throws IOException{
		//예외처리(스프링 처리 위임)
		
		String savePath = "c:/upload/";
		String originalname1 = uploadfile.getOriginalFilename(); 
		String beforeext1 = originalname1.substring(0, originalname1.indexOf(".")); 
		String ext1 = originalname1.substring(originalname1.indexOf(".")); // 
		String newname1 = beforeext1+"("+UUID.randomUUID().toString()+")"+ext1;
		File servefile1 = new File(savePath+newname1); 
		System.out.println(savePath+newname1);
		uploadfile.transferTo(servefile1);
		return "{\"result\" : \"잘 받았습니다.\"}";
	}
	
}








