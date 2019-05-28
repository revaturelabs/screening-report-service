package com.revature.screenforce.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.beans.ViolationType;

@FeignClient(url="localhost:8181/bucket", name="bucket")
public interface AdminBucketClient {


	//http request methods to other services 
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	List<Bucket> getBucketById(); 
	
}
