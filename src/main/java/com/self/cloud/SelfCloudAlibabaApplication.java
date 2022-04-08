package com.self.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.self.cloud.dao")
@SpringBootApplication
public class SelfCloudAlibabaApplication {

	// 启动类
	public static void main(String[] args) {
		SpringApplication.run(SelfCloudAlibabaApplication.class, args);
	}

}
