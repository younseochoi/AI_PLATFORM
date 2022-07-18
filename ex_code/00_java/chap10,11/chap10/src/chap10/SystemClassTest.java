package chap10;

public class SystemClassTest {

	public static void main(String[] args) {
		//1970년 1월 1일 0시 0분 0초 ~
		long start = System.currentTimeMillis();
		System.out.println("최초시각(1/1000초단위)=" + start);
		System.out.println("자바버전=" + System.getProperty("java.version"));
		System.out.println("os=" + System.getProperty("os.name"));
		System.out.println("자바저장디렉토리=" + System.getProperty("user.dir"));
		System.out.println("파일분리자=" + System.getProperty("file.separator"));
		
		if(true) {System.exit(0); } //종료
		for(int i = 1; i <= 10000; i++) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("종료시각(1/1000초단위)=" + (System.currentTimeMillis() - start  ) );		
	}

}
  //   c:/test/aaa/A.java