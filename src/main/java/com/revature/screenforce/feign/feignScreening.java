package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.Question;
import com.revature.screenforce.beans.Screening;


@FeignClient(name = "screening", url = "http://localhost:8183/screening")
public interface feignScreening {
	@RequestMapping(method = RequestMethod.GET)
    List<Screening> getAllScreening();
}


	
