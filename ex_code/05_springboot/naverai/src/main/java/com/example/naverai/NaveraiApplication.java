package com.example.naverai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //spring boot app 실행 tomcat 내장 실행-8080
@ComponentScan(basePackages = "chatbot")
@ComponentScan(basePackages = "test")
@ComponentScan(basePackages = "ocr")
@ComponentScan(basePackages = "voice")
@ComponentScan(basePackages = "csr")
@ComponentScan(basePackages = "object")
@ComponentScan(basePackages = "pose")
@ComponentScan(basePackages = "cfr")
@ComponentScan //현재패키지
public class NaveraiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaveraiApplication.class, args);
	}

}
