package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {

	//폴더 파일리스트 보여준다
	@RequestMapping("/filedownloadlist")
	public ModelAndView downloadlist() {
		File f= new File("/Users/choiyoonseo/Downloads/upload"); //디렉토리와 파일 접근가능 정보객체
		String[] filearray =  f.list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("filearray", filearray);
		mv.setViewName("upload/downloadlist");
		return mv;
	}
	
	//선택한 파일 다운로드 메소드 
	@RequestMapping("/filedownloadresult")
	public void downloadresult(String filename, HttpServletResponse response) throws IOException{
		
		//void 면다운로드 뷰 없다.
		File f = new File("/Users/choiyoonseo/Downloads/upload/"+filename);
		int len = (int) f.length(); //byte
		response.setContentType("application/download"); //위처럼 파일 다운로드를 위해 설정할 태그
		response.setContentLength(len);
		response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
		
		OutputStream out = response.getOutputStream(); //브라우저 응답
		FileInputStream fin = new FileInputStream(f); //파일 입력객체 생성
		FileCopyUtils.copy(fin, out);  //fin (다운로드내용) -->out(브라우저)q복사		
	}
	
}
