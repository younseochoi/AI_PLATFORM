package ex1;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.naverai.NaverService;

@Service("mapservice")
public class MapService implements NaverService {

	HashMap<String, String> map = new HashMap<String,String>();
	public MapService() {
		map.put("이름이 뭐야?", "네이버 클로버야");
		map.put("무슨일을하니?","ai 서비스관련일을해");
		map.put("멋진 일을 하는구나", "고마워");
		map.put("난 훌륭한 개발자가 될거야", "넌 할 수 있어");
		map.put("잘 자", "내꿈꿔");
		map.put("안녕?", "반가워! 너 이름이 윤서구나!");
		map.put("널 누가 만들었지?", "니가 만들었어!");
		map.put("흠", "무슨 고민있어?");
		map.put("알았어", "벌써 가는거야?");
		map.put("아 배고파", "나도..햄버거 먹고싶다.");
		map.put("내 이름이 뭐지?", "최윤서잖아, 맞지?");
		map.put("노래 불러줘", "This that pink venom, This that pink venom, This that pink venom, wa wa wa");
		map.put("그거말고 다른 노래", "형돈이가 랩을한다 홍홍홍");
		map.put("너 노래 못부른다", "말이 너무 심한거 아니야?");
		map.put("미안", "넓은 아량으로 한 번만 봐줄게! 다신 그러지마");
		map.put("우이", "바보똥때까리");
		map.put("우이는 무슨 고양이?", "야통이");
		map.put("셔는 무슨 고양이?", "삼색");
		
//		무슨일을하니?–ai 서비스관련일을해 멋진 일을 하는구나 – 고마워
//				난 훌륭한 개발자가 될거야 – 넌 할 수 있어
//				잘 자 – 내꿈꿔
		
	}
	@Override
	public String test(String request) {
		String response = map.get(request);
		if(response==null||response.equals("")) {
			response = "내가 대답할 수 없는 질문이야 미안해";
		}
		return response;
	}

}
