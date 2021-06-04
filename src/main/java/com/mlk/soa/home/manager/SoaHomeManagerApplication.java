package com.mlk.soa.home.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.mlk.soa.home.manager.mapper")
@EnableSwagger2
public class SoaHomeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaHomeManagerApplication.class, args);
	}

}
