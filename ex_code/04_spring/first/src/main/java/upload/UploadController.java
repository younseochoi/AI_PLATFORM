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
	public String uploadform() {
		return "upload/uploadform";
	}
	@PostMapping("/fileupload")
	String uploadprocess(@ModelAttribute("dto") UploadDTO dto) 
	throws IOException {
	 // dto 같은 이름 변수에 파라미터 매핑되어있다
	// file1, file2 의 이름과 내용 서버 c:\\upload 폴더에 저장 	
	// 파일내용을 복사하여 c:\\upload 폴더에 파일명 붙여넣기
	
		//폴더 없으면 수동 생성
		String savePath ="c:/upload/";
		
		MultipartFile mf1 = dto.getFile1();
		if(!mf1.isEmpty()) {
			String originalname1 = mf1.getOriginalFilename(); //a.txt
			String beforeext1 = originalname1.substring(0, originalname1.indexOf(".")); //a
			String ext1 = originalname1.substring(originalname1.indexOf(".")); // .txt
			String newname1 = beforeext1+"("+UUID.randomUUID().toString()+")"+ext1;
			File servefile1 = new File(savePath+newname1); // a(012334434).txt
			System.out.println(savePath+newname1);
			mf1.transferTo(servefile1);
		}
			
		MultipartFile mf2 = dto.getFile2();
		if(!mf2.isEmpty()) {
			String originalname2 = mf2.getOriginalFilename();
			String beforeext2 = originalname2.substring(0, originalname2.indexOf(".")); //a
			String ext2 = originalname2.substring(originalname2.indexOf(".")); // .txt
			String newname2 = beforeext2+"("+UUID.randomUUID().toString()+")"+ext2;
			File servefile2 = new File(savePath+newname2);	
			mf2.transferTo(servefile2);

		}
		//System.out.println("작성자=" + dto.getName());
		//System.out.println("설명=" + dto.getDescription());
		//파일명 추출
		//MultipartFile 메소드
		//System.out.println("1번째파일명=" + mf1.getOriginalFilename());
		//System.out.println("2번째파일명=" + mf2.getOriginalFilename());
		//파일길이
		//System.out.println("1번째파일길이=" + mf1.getSize());
		//System.out.println("2번째파일길이=" + mf2.getSize());
		

		

		
		return "upload/uploadprocess";

	}
}








