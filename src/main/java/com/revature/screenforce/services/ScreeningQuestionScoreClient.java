package com.revature.screenforce.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(url="localhost:8183/questionScore", name="questionScore") //name can be any name
public interface ScreeningQuestionScoreClient {

	@RequestMapping(method = RequestMethod.GET, value="/{screeningId}")
	
	com.revature.screenforce.dtos.SimpleQuestionScore getScoresByScreeningId(@PathVariable(value="screeningId") int screeningId); 
	
	
}
