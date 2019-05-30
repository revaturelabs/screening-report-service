package com.revature.screenforce.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.ViolationType;

//JU - use feign client to consume http resources 
@FeignClient(url="localhost:8183/violation", name="violation") //name can be anything
public interface ScreeningViolationClient {

	//JU - http request methods to other services 
	@RequestMapping(method = RequestMethod.GET)
	List<com.revature.screenforce.dtos.ViolationType> getViolationTypes(); 
	
	//JU
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	List<com.revature.screenforce.dtos.SoftSkillViolation> getSoftSkillViolations(); 
	
}
