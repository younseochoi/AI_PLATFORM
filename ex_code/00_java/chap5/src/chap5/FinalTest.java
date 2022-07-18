package chap5;

final class Math{
	int abs(int i) {//절대값(절대불변의진리구현- 수정불가능)
		if(i >= 0) { return i; }
		else { return i * -1 ; }
	}
	//제곱(){}
	//제곱근(){}
	//삼각함수(){}
}
class MyMath /*extends Math*/{
	Math i = new Math();
}
public class FinalTest {
	public static void main(String[] args) {
		MyMath m = new MyMath();
		int r1 = m.i.abs(10);
		System.out.println("10 의 절대값은 " + r1);
	} 
}
