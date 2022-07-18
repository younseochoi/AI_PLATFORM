package chap10;

public class ExceptionTest {
// 2개 이상 입력. 정수변경 가능. 0 은 아니어야 한다
// 예외발생 가능성 있다 - 미리 예측 예외 제거하자 - "견고한 언어다"	 --> 예외처리 --> 예외처리구문 수행, main 끝까지 완료
	public static void main(String[] args) {
		int j = 0;
		try{
			int i = Integer.parseInt(args[0]);
			j = Integer.parseInt(args[1]);
			System.out.println( i / j); 
			//new ArithmeticExcetion() 오류발생
			//try 중단 - catch 이동
		}
		catch(ArithmeticException e) {//하위예외
			System.out.println("0은 입력하지 마세요");
		}
		catch(Exception e) {//상위예외
			System.out.println("그밖의 다른 예외들 동일 처리");
		}
		finally {
			System.out.println("항상 출력");
		}
		/*catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("2개이상의 값을 입력하세요");
		}
		catch(NumberFormatException e) {
			System.out.println("정수 변환 가능값을 입력하세요");
		}*/
		//모든 예외에 대해 동일 처리 블록 1개
		
		System.out.println("메인완료");

	}

}
