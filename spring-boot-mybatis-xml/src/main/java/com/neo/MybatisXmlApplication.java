package com.neo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neo.mapper")
public class MybatisXmlApplication {

	public static void main(String[] args) {
//		SpringApplication springApplication = new SpringApplication(MybatisXmlApplication.class);
//		springApplication.setBannerMode(Banner.Mode.LOG);
//		springApplication.run(args);
		SpringApplication.run(MybatisXmlApplication.class, args);
	}
}
