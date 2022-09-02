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
	public ModelAndView faceinput() {
		File f = new File(NaverInform.path);
		String[] filenames = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filenames",filenames);
		mv.setViewName("cfr/faceinput");
		return mv;
	}
	
	@GetMapping("/faceresult")
	public ModelAndView faceresult(String image) {
		String result = service.test(image);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("cfr/faceresult");
		return mv;
	}
	
	@GetMapping("/face2")
	public ModelAndView faceinput2() {
		File f = new File(NaverInform.path);
		String[] filenames = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filenames",filenames);
		mv.setViewName("cfr/faceinput2");
		return mv;
	}
	
	@GetMapping("/faceresult2")
	public ModelAndView faceresult2(String image) {
		String result = service2.test(image);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("cfr/faceresult3");
		return mv;
	}
	
}
