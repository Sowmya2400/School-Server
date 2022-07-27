package com.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ssm"})
@EntityScan(basePackages = "com.ssm")
public class SSM_SchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(SSM_SchoolApplication.class, args);
		
	}
}
