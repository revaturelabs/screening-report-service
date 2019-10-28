package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.revature.screenforce.beans.SkillType;



@FeignClient(name = "SkillType", url = "http://localhost:8181/skilltype")
public interface feignSkillType {
	@RequestMapping(method = RequestMethod.GET)
	List<SkillType> getSkills();
}


