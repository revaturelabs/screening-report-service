package com.revature.screenforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import feign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class ScreeningReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreeningReportServiceApplication.class, args);
	}

}

