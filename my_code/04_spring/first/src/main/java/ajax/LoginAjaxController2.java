package ajax;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import board.spring.mybatis.MemberDTO;
import board.spring.mybatis.MemberService;

@Controller
public class LoginAjaxController2 {

	@Autowired
	MemberService service;
	
	@GetMapping("/loginajax2")
	public String loginform() {
		return "ajax/loginform2";
	}
	
//	@ResponseBody
	@RequestMapping(value="/loginajax2", produces= {"application/json;charset=utf-8"}  )
	public @ResponseBody MemberDTO loginresult(MemberDTO dto) {
		// id있고 비번맞으면 데이터 베이스 MemberDTO 객체 가져오기
		if(dto.getPassword() == 1234 && dto.getId().equals("ajax")) {
			dto.setEmail("lecky@gmail.com");
			dto.setName("세바스찬렠키");
			dto.setPhone("010-1234-1234");
			dto.setRegdate("2022-08-25");
		}
		return dto;
				
	}
	
	@RequestMapping(value = "/memberlistajax", produces= {"application/json;charset=utf-8"})
	public @ResponseBody List<MemberDTO> memberlistajax(){
		List<MemberDTO> memberlist = service.memberlist();
		return memberlist;
	}
	
//	url : "memberpasswordajax",
//	data : { 'id' : $(this).attr("id")},
//	type : "get",
	@ResponseBody
	@RequestMapping("/memberpasswordajax")
	public String memberPassword(String id){
		List<MemberDTO> list = service.oneMember(id);
		String pw = String.valueOf(list.get(0).getPassword());
		//pw.substring(0, 2) //처음부터 두글자 가져와
		pw = pw.substring(0, 2)+"*".repeat(pw.length()-2);
		return "{\"id\" : \""+id+"\", \"password\" : \""+pw+"\" }";
	}
	
	@ResponseBody
	@RequestMapping("/memberpasswordajax2/{id}")
	public String memberPassword2(@PathVariable("id") String id){
		List<MemberDTO> list = service.oneMember(id);
		String pw = String.valueOf(list.get(0).getPassword());
		//pw.substring(0, 2) //처음부터 두글자 가져와
		pw = pw.substring(0, 1)+"*".repeat(pw.length()-1);
		return "{\"id\" : \""+id+"\", \"password\" : \""+pw+"\" }";
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadajax", produces = {"application/json;charset=utf-8"})
	public String uploadajax(MultipartFile uploadfile) throws IOException {
		
		String savePath = "/Users/choiyoonseo/Downloads/upload/";
		String originalname1 = uploadfile.getOriginalFilename(); //a.txt
		String beforeext1 = originalname1.substring(0, originalname1.indexOf("."));  //a
		String ext1 = originalname1.substring(originalname1.indexOf("."));  //.txt
		String newname1 = beforeext1 +"(" +UUID.randomUUID().toString() +")"+ ext1;
		File servefile1 = new File(savePath+newname1);
		uploadfile.transferTo(servefile1);
		return "{ \"result\" : \"잘받았습니다.\"}";
	}
}
