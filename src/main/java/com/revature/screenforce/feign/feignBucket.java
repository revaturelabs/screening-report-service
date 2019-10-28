package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.Bucket;

@FeignClient(name = "bucket", url = "http://localhost:8181/bucket")
public interface feignBucket {
	@RequestMapping(method = RequestMethod.GET)
    List<Bucket> getBucket();
	

	@RequestMapping(value="/{bucketId}", method = RequestMethod.GET)
	Bucket getBucketByBucketId(@PathVariable Integer bucketId) ;
	
}
