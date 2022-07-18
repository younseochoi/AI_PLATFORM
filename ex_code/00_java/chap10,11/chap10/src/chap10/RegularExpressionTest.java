package chap10;

public class RegularExpressionTest {

	public static void main(String[] args) {
		/*String phones[]= 
			{"010-1234-56", "011-1234-567", "010-12345-6789","010-^^^2-"};
		// 010이나 011-시작 알파벳한글숫자특수문자들3,5자리  -0개이상숫자종료
		for(int i = 0; i < phones.length; i++) {
			System.out.println(phones[i].matches("(010|011)-.{3,5}-[0-9]*"));
			//System.out.println(phones[i].contains("1234"));
			//System.out.println(phones[i].equals("1234"));
		}
		*/
		
		String address = "서울시-서초구/서초동 테크부루:아카데미 3층";//6개
		//String [] result = address.split("."); //정규식 아무 문자 1개 의미 내포
		String [] result = address.split("(-|/|:| )"); // 특수문자 '.' 형태 
		System.out.println(result.length);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
// . + * ? 분리자 이거나 분리가 복수개 -- 정규표현식
	}

}
