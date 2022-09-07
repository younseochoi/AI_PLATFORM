package com.example.naverai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan //지금현재 패키지도 선언 
@ComponentScan(basePackages = "cfr")
@ComponentScan(basePackages = "pose")
@ComponentScan(basePackages = "object")
@ComponentScan(basePackages = "csr")
@ComponentScan(basePackages = "voice")
@ComponentScan(basePackages = "ocr")
@ComponentScan(basePackages = "ex1")
@ComponentScan(basePackages = "chatbot")
public class NaveraiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaveraiApplication.class, args);
	}

}
