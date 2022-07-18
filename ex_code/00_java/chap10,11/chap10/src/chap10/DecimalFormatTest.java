package chap10;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static void main(String[] args) {
		double num = 4567.80;
		//# 정수부분 - 표현 숫자가 더 커도 잘 표현
		//# 소수점이하부분- 정확 자릿수 표현(반올림)
		DecimalFormat df = new DecimalFormat("###,###.#");//6자리정수.1자리소수
		System.out.println(df.format(num));
		df = new DecimalFormat("000,000.#");//6자리고정정수.1자리소수
		System.out.println(df.format(num));
		df = new DecimalFormat("+000,000.00;-000,000.00");//6자리고정정수.2자리고정소수
		System.out.println(df.format(num));
		df = new DecimalFormat("#.00");//정수자리수.2자리고정소수
		System.out.println(df.format(10 / (double) 3));
		
	}

}
