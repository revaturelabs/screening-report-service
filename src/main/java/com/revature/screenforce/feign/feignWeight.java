package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.revature.screenforce.beans.Weight;

@FeignClient(name = "weight", url = "http://localhost:8181/weight")
public interface feignWeight {

	@RequestMapping(method = RequestMethod.GET)
	List<Weight> getWeights() ;
	
	@RequestMapping(value = "/{skillTypeId}/{bucketId}",method = RequestMethod.GET)
    Weight getWeightFromIds(@PathVariable Integer skillTypeId,@PathVariable Integer bucketId);
}

