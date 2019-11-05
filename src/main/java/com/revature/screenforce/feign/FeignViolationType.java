package com.revature.screenforce.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.revature.screenforce.beans.ViolationType;

@FeignClient(name = "violation", url = "http://localhost:8183/violation")
public interface FeignViolationType {
	
	@RequestMapping(method = RequestMethod.GET)
	List<ViolationType> getViolationTypes();
}
