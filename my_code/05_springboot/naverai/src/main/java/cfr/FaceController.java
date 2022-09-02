package cfr;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;
import com.example.naverai.NaverService;

@Controller
public class FaceController {
	
	@Autowired
	@Qualifier("faceservice")
	NaverService service;
	
	@Autowired
	@Qualifier("faceservice2")
	NaverService service2;
	
	@GetMapping("/face")
	public ModelAndView faceInput() {
		System.out.println("컨트롤러");
		File f = new File(NaverInform.path);
		String [] filenames = f.list();
//		for(int i =0;i<filenames.length;i++) {
//			System.out.println(filenames[i]);
//		}
		ModelAndView mv= new ModelAndView();
		//ai_images 폴더 이미지만 추출하여 전달
		mv.addObject("filenames", filenames);
		mv.setViewName("cfr/faceinput");
		return mv;
	}
	
	@GetMapping("/faceresult")
	public ModelAndView faceResult(String image) {
		String result = service.test(image);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("cfr/faceresult");
		mv.addObject("result", result);
		return mv;
	}
	
	@GetMapping("/face2")
	public ModelAndView faceInput2() {
		System.out.println("컨트롤러");
		File f = new File(NaverInform.path);
		String [] filenames = f.list();
		ModelAndView mv= new ModelAndView();
		
		//ai_images 폴더 이미지만 추출하여 전달
		mv.addObject("filenames", filenames);
		mv.setViewName("cfr/faceinput2");
		return mv;
	}
	
	@GetMapping("/faceresult2")
	public ModelAndView faceResult2(String image) {
		String result = service2.test(image);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("cfr/faceresult3");
		mv.addObject("result", result);
		return mv;
	}
	
}
