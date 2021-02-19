package com.youguang.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.youguang.admin.mapper")
public class YouguangAdminApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(YouguangAdminApplication.class, args);
	}
	
}

