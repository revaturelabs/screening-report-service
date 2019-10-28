package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.ScheduledScreening;

@FeignClient(name = "feignScheduledScreening", url = "http://localhost:8183/screening/scheduled")
public interface feignScheduledScreening {
	@RequestMapping(method = RequestMethod.GET)
    List<ScheduledScreening>  getAllScheduledScreenings();
}

