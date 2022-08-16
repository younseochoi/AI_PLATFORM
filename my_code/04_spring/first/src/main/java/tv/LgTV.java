package tv;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("LG tv - 전원켜다.");
	}
	
	public void powerOff() {
		System.out.println("LG tv - 전원끄다.");
	}
	
	public void volumeUp(int i) {
		System.out.println("LG tv - "+i+"만큼 볼륨높이다.");
	}
	
	public void volumeDown(int i) {
		System.out.println("LG tv - "+i+"만큼 볼륨낮추다.");
	}
}
