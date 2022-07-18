package chap10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		long mill = System.currentTimeMillis();//현재시각 1/1000초
		
		Date now = new Date();//현재시각(초단위 동일). 출력형태 정해졌다
		Date now2 = new Date(mill);//현재시각(초단위 동일)

		System.out.println(now2);
		System.out.println(now);
		
		//Date 클래스의 메소드들은 jdk 변화되면서 사용 자제 표시 - deprecated method 
		// 사용해도 컴파일오류 발생하지는 않는다 
		// 새 프로젝트 사용 자제 권고 (이전 진행 프로젝트 메소드 이미 사용중 진행)
		// 기능은 Calendar 클래스 이동 권고
		
		Calendar cal = Calendar.getInstance();//NEW X
		System.out.println(cal);
		//now.getYear();//년도 사용 자제
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // MONTH = 6 저장(7월)
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.print("현재시각은 " + year + "년도 " + month + " 월 " + day + " 일 ");
		System.out.println(hour + " 시 " + minute + " 분 " + second + " 초입니다. ");	
		
		if(cal.get(Calendar.DAY_OF_WEEK) == 2) {
			System.out.println("월요일-MONDAY");
		}
		//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		// 22-07-04 13:23:24 요일 미리 날짜시각형식 미리 지정
		//SimpleDateFormat - 간결 날짜 시각 형식 - 날짜시간정보는 Date객체나 Calendar객체 생성하여 정보 형식을 지정
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");  //d-이달중 몇일 , D-1년중 몇일
		String result = sdf.format(cal.getTime()); // now2, cal.getTime()
		System.out.println(result);
	}

}
