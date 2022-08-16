package spring.tv;

public class SamsungTV implements TV{ //plain old java object = pojo
	public void powerOn() {
		System.out.println("삼성tv-전원켜다");
	}
	public void powerOff() {
		System.out.println("삼성tv-전원끄다");
	}
	public void volumeUp(int i) {
		System.out.println("삼성tv-" + i + " 만큼 볼륨높이다");
	}
	public void volumeDown(int i) {
		System.out.println("삼성tv-" + i + " 만큼 볼륨낮추다");
	}
}
