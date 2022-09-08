package com.example.naverai;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import chatbot.PizzaDAO;

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
@ComponentScan(basePackages = "bean")
@ComponentScan(basePackages = "pizza")
@MapperScan(basePackages = "chatbot")
//@MapperScan(basePackageClasses = PizzaDAO.class) 위에 거랑 똑같음! 
public class NaveraiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaveraiApplication.class, args);
	}

}
