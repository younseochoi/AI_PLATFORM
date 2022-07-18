package chap10;

import java.util.regex.Pattern;

public class StringClassTest {

	public static void main(String[] args) {
		System.out.println
		(Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", "010-222-3333" )); 
		System.out.println
		(Pattern.matches("011-\\d{3,4}-\\d{4}", "010-2223-3333")); 
		System.out.println
		(Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", "010-2223-3333")); 
		System.out.println
		(Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", "010-222-가333" )); 
		
		System.out.println
		("010-222-가333".matches("\\d{3}-\\d{3,4}-\\d{4}"));
		char c[] = new char[100];
		int index = 0;
		try {
			while(true) {
				int result = System.in.read();
				if(result == '\n') { break;}
				c[index++] = (char)result;
				
			}//while end
			
			String sc = new String(c);
			System.out.println(sc.toUpperCase());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
