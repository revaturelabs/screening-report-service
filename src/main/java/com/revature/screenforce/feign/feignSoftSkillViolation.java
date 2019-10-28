package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.SoftSkillViolation;

@FeignClient(name = "SoftSkillViolation", url = "http://localhost:8183/violation/all")
public interface feignSoftSkillViolation {
	@RequestMapping(method = RequestMethod.GET)
	List<SoftSkillViolation> getSoftSkillViolations() ;
}

