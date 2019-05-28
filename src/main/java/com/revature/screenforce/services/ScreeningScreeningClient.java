package com.revature.screenforce.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(url="localhost:8183/screening", name="screening")
public interface ScreeningScreeningClient {

		//http request methods to other services 
		@RequestMapping(method = RequestMethod.GET)
		List<com.revature.screenforce.dtos.Screening> getScreenings();
	
}
