package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// <context:component-scan base-pacakage="a.b.test">
//@ComponentScan(basepackage="a.b.teset")
@SpringBootApplication
//1. 스트링 부트 시작 클래스 -tomcat 시작
// @ComponentScan(basePackages = "com.example.demo")는 명시적 설정시 사라짐
@ComponentScan // 이 패키지도 읽겠다
@ComponentScan(basePackages = "mycontroller")
@ComponentScan(basePackages = "upload")
@ComponentScan(basePackages = "board.spring.mybatis")
//@Mapper Scan 설정
@MapperScan(basePackages = "board.spring.mybatis")
@MapperScan(basePackages = "upload")
public class Myboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(Myboot1Application.class, args);
	}

}
