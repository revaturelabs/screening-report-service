package com.revature.screenforce.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//JU
@FeignClient(url="localhost:8183/questionScore", name="questionScore") 
public interface ScreeningQuestionScoreClient {
	
	//JU - still needs testing.
	@RequestMapping(method = RequestMethod.GET, value="/{screeningId}")
	com.revature.screenforce.dtos.SimpleQuestionScore getScoresByScreeningId(@PathVariable(value="screeningId") int screeningId); 
	
	//JU -  works.
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	List<com.revature.screenforce.dtos.SimpleQuestionScore> getSimpleQuestionScores(); 
	
}
