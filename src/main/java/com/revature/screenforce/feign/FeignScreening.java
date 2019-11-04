package com.revature.screenforce.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.revature.screenforce.beans.Screening;

@FeignClient(name = "screening", url = "http://localhost:8183/screening")
public interface FeignScreening {
	
	@RequestMapping(method = RequestMethod.GET)
	List<Screening> getAllScreening();

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Screening getScreeningById(@PathVariable Integer id);
}
