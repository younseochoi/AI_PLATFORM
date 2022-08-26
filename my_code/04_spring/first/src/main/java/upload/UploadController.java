package upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/fileupload")
	public String uploadForm() {
		return "upload/uploadform";
	}
	
	@PostMapping("/fileupload")
	public String uploadProcess(@ModelAttribute("dto") UploadDTO dto) throws IOException {
		String savePath="/Users/choiyoonseo/Downloads/upload/";
		
		MultipartFile file1 = dto.getFile1();
		if(!file1.isEmpty()) {
			String originalname1 = file1.getOriginalFilename(); //a.txt
			String beforeext1 = originalname1.substring(0, originalname1.indexOf("."));  //a
			String ext1 = originalname1.substring(originalname1.indexOf("."));  //.txt
			String newname1 = beforeext1 +"(" +UUID.randomUUID().toString() +")"+ ext1;
			File servefile1 = new File(savePath+newname1);
			file1.transferTo(servefile1);
		}
		
		MultipartFile file2 = dto.getFile2();
		if(!file2.isEmpty()) {
			String originalname2 = file2.getOriginalFilename();
			String beforeext2 = originalname2.substring(0, originalname2.indexOf("."));  //a
			String ext2 = originalname2.substring(originalname2.indexOf("."));  //.txt
			String newname2 = beforeext2 +"(" +UUID.randomUUID().toString() +")"+ ext2;
			File servefile2= new File(savePath+newname2);
			file2.transferTo(servefile2);
		}

		//file1, file2 파일이름과 내용 서버에 저장 
		System.out.println("작성자 : "+dto.getName()+ " 설명 :"+dto.getDescription());
		
		//파일명 추출
		//MultipartFile 메소드
//		System.out.println("1번째 파일명 = "+file1.getOriginalFilename());
//		System.out.println("2번째 파일명 = "+file2.getOriginalFilename());
//
//		//파일 길이
//		System.out.println("1번째 파일길이 = "+file1.getSize());
//		System.out.println("2번째 파일길이 = "+file2.getSize());
		
		//파일 명 추출
	//	String originalname2 = file2.getOriginalFilename();
		//빈 파일 객체 생성
		//File servefile2 = new File(savePath+originalname2);
		
		//파일 위 경로로 복사 후 붙여넣기
		//file2.transferTo(servefile2);
		
		return "upload/uploadprocess";
	}
}
