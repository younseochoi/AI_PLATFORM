package com.example.naverai;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //설정 xml 파일 대신
public class MyWebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:/Users/choiyoonseo/Downloads/upload/");
		//폴더 추가하고싶으면 위문장 추가
		registry.addResourceHandler("/naverai/**").addResourceLocations("file:"+NaverInform.path);
		//폴더 추가하고싶으면 위문장 추가
		//localhost:8081/naverai/xxx
	}

}
