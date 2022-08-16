package tv;

public class TVFactory {
	//매개변수 "삼성", "엘지" 해당 tv 객체 생성
	public TV getTV(String name) {
		if(name.equals("삼성")) {
			return new SamsungTV();
		}
		else if(name.equals("엘지")) {
			return new LgTv();
		}
		else {
			return null;
		}
	}
}
