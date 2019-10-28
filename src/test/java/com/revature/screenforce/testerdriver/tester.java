package com.revature.screenforce.testerdriver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.feign.feignBucket;
import com.revature.screenforce.feign.feignQuestion;
import com.revature.screenforce.feign.feignQuestionScore;
import com.revature.screenforce.feign.feignScheduledScreening;
import com.revature.screenforce.feign.feignScreening;
import com.revature.screenforce.feign.feignSkillType;
import com.revature.screenforce.feign.feignSoftSkillViolation;
import com.revature.screenforce.feign.feignViolationType;
import com.revature.screenforce.feign.feignWeight;
import com.revature.screenforce.services.ReportsService;


public class tester {

	
	public static void main(String[] args) {
		ReportsService r = new ReportsService();
		r.testGetAllBuckets();

	}

}
