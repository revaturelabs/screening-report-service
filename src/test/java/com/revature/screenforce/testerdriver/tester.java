package com.revature.screenforce.testerdriver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.services.ReportsService;


public class tester {

	
	public static void main(String[] args) {
		ReportsService r = new ReportsService();

	}

}
