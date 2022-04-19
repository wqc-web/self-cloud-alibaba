package com.self.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@EnableFeignClients
@MapperScan(basePackages = "com.self.user.dao")
@SpringBootApplication
public class SelfUserApplication {

	// 启动类
	public static void main(String[] args) {
		SpringApplication.run(SelfUserApplication.class, args);
	}

}
