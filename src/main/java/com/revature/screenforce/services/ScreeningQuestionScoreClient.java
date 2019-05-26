package com.revature.screenforce.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.beans.ViolationType;

@FeignClient(url="localhost:8183/questionScore", name="questionScore") //name can be any name
public interface ScreeningQuestionScoreClient {

	@RequestMapping(method = RequestMethod.GET, value="/{screeningId}")
	List<SimpleQuestionScore> getScoresByScreeningId(); 
	
	
}
