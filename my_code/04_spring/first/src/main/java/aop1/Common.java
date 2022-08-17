package aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {
	long starttime = System.currentTimeMillis(); //1/1000 
	
	public void a() {
		System.out.println("==> a 메소드는 핵심관심의 사전호출 : "+new Date(starttime));
	}
	
	public void b() {
		long endtime = System.currentTimeMillis();
		System.out.println("==> b 메소드는 핵심관심의 이후 호출 (수행시간) : "+(endtime-starttime));
	}
	
	public void c(ProceedingJoinPoint joinpoint) { //핵심클래스 정보
		try {
		System.out.println
		("===>c메소드--around 이전 결과입니다." );//before
		Object returnValue = joinpoint.proceed();//핵심관심메소드 실행
		if(returnValue != null)
		System.out.println
		("===>c메소드--around 이후 리턴값=" + returnValue);//after	
		System.out.println
		("===>c메소드--around 이후  " 
		+joinpoint.getTarget());//핵심관심객체
		System.out.println
		("===>c메소드--around 이후  " 
		+joinpoint.toLongString());//핵심관심선택메소드선언
		
		Object args[] = joinpoint.getArgs();//핵심관심메소드 매개변수배열	
		for(Object s : args) {
		System.out.println
		("===>c메소드--around 이후  " +s);	
		}
		}catch(Throwable e) {
		System.out.println(e);
		}
	}
}
