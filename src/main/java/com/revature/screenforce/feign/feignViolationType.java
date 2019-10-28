package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.SkillType;
import com.revature.screenforce.beans.ViolationType;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@FeignClient(name = "violation", url = "http://localhost:8183/violation")
public interface feignViolationType {
	@RequestMapping(method = RequestMethod.GET)
	List<ViolationType> getViolationTypes();
}
