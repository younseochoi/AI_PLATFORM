package spring.tv;

public class LgTv implements TV {
	public void powerOn() {
		System.out.println("엘지tv-전원켜다");
	}
	public void powerOff() {
		System.out.println("엘지tv-전원끄다");
	}
	public void volumeUp(int v) {
		System.out.println("엘지tv-볼륨 " + v + " 씩 높이다");
	}
	public void volumeDown(int v)  {
		System.out.println("엘지tv-볼륨 " + v + " 씩 낮추다");
	}
}
