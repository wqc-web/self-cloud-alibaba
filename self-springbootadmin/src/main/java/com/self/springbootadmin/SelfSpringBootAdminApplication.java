package com.self.springbootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class SelfSpringBootAdminApplication {

    // 启动类
    public static void main(String[] args) {
        SpringApplication.run(SelfSpringBootAdminApplication.class, args);
    }

}
