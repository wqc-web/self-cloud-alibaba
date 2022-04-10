package com.self.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.self")
@SpringBootApplication
public class SelfUserApplication {

	// 启动类
	public static void main(String[] args) {
		SpringApplication.run(SelfUserApplication.class, args);
	}

}
