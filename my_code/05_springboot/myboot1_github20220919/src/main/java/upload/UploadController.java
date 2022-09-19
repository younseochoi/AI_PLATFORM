package upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	@Autowired
	@Qualifier("uploadservice")
	UploadService service;
	
	@GetMapping("/fileupload")
	public String uploadForm() {
		return "upload/uploadform";
	}
	
	@PostMapping("/fileupload")
	public String uploadProcess(@ModelAttribute("dto") UploadDTO dto) throws IOException {
		String savePath="/Users/choiyoonseo/Downloads/upload/";
		
		//해시맵으로 넘겨주기
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("name", dto.getName());
		map.put("description", dto.getDescription());
		
		MultipartFile file1 = dto.getFile1();
		if(!file1.isEmpty()) {
			String originalname1 = file1.getOriginalFilename(); //a.txt
			String beforeext1 = originalname1.substring(0, originalname1.indexOf("."));  //a
			String ext1 = originalname1.substring(originalname1.indexOf("."));  //.txt
			String newname1 = beforeext1 +"(" +UUID.randomUUID().toString() +")"+ ext1;
			dto.setFilename1(newname1);
			map.put("file1", newname1);
			File servefile1 = new File(savePath+newname1);
			file1.transferTo(servefile1);
		}
		
		MultipartFile file2 = dto.getFile2();
		if(!file2.isEmpty()) {
			String originalname2 = file2.getOriginalFilename();
			String beforeext2 = originalname2.substring(0, originalname2.indexOf("."));  //a
			String ext2 = originalname2.substring(originalname2.indexOf("."));  //.txt
			String newname2 = beforeext2 +"(" +UUID.randomUUID().toString() +")"+ ext2;
			dto.setFilename2(newname2);
			map.put("file2", newname2);
			File servefile2= new File(savePath+newname2);
			file2.transferTo(servefile2);
		}

		//file1, file2 파일이름과 내용 서버에 저장 
		System.out.println("작성자 : "+dto.getName()+ " 설명 :"+dto.getDescription());
		
		//dto로넘겨서 db저장
		//int result = service.uploadFile(dto);
		//hashmap으로 넘겨서 db저장
		int result = service.uploadFile(map);
		System.out.println(result +" :: DB 저장 결과");
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
	
	//inputname 메소드
	@RequestMapping("/input")
	public String inputName() {
		return "upload/inputname";
	}
	
	//outputname 메소드
	@RequestMapping("/output")
	public ModelAndView outputName(String name) {
		System.out.println(name);
		ModelAndView mv = new ModelAndView();
		List<Map<String, String>> dto = service.outputName(name);
		//내가 필요한건 이 파일의 확장자가 이미지인지,
		String [] imgexp = {"jpg","jfif","png"};
		ArrayList<String> img1= new ArrayList<String>();
		for(int i =0;i<dto.size();i++) {
			String filename1 = dto.get(i).get("filename1");
			String filename2 = dto.get(i).get("filename2");
			String ext1,ext2;
			String[] extarr1 = filename1.split("\\.");
			String[] extarr2 = filename2.split("\\.");
			
			if(extarr1.length>1) {
				ext1=extarr1[extarr1.length-1];
			}else {
				ext1=extarr1[0];
			}//파일의 확장자 분리
			
			if(extarr2.length>1) {
				ext2=extarr2[extarr2.length-1];
			}else {
				ext2=extarr2[0];
			}//파일의 확장자 분리
			
			for(int j=0;j<imgexp.length;j++) {
				if(ext1.equals(imgexp[j])) {
					img1.add(filename1);
				}
				if(ext2.equals(imgexp[j])) {
					img1.add(filename2);
				}
			}
		}
		System.out.println(img1);
//		String [] ext = test.split("\\.");
//		System.out.println(ext.length);
//		for(int i=0;i<ext.length;i++) {
//			System.out.println(ext[i]);
//		}
		
		
//		
//		ArrayList<String> img1= new ArrayList<String>();
//		ArrayList<String> img2= new ArrayList<String>();
//		String [] imgexp = {"jpg","jfif","png"};
//		String[] imgexp1 = dto.get(0).filename1.split(".");
//		System.out.println(imgexp1);
	//	for(int i=0;i < dto.size();i++) {
	//		String[] imgexp1 = dto.get(i).filename1.split(".");
	//		System.out.println(imgexp1);
//			String[] imgexp2 = dto.get(i).filename2.split(".");
//			for(int j=0;j<imgexp.length;j++) {
//				if(imgexp1[imgexp1.length-1].equals(imgexp[j])) {
//					img1.add(dto.get(i).filename1);
//				}
//				if(imgexp2[imgexp2.length-1].equals(imgexp[j])) {
//					img2.add(dto.get(i).filename2);
//				}
//			}
		//}
//		System.out.println(img1);
		mv.addObject("img1", img1);
//		mv.addObject("img2",img2);
		
		mv.setViewName("upload/outputname");
		return mv;
	}
	//service 추가 - dao upload-mapping.xml 추가
}
