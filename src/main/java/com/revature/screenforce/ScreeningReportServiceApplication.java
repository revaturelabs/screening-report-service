package com.revature.screenforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ScreeningReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreeningReportServiceApplication.class, args);
	}

}

