package com.revature.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url="http://localhost8080/employees")//this is not the actual base.  just an example
public interface EmailClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/getEmails")
	List<String> getAllEmails();

}
