package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.Question;
@FeignClient(name = "question", url = "http://localhost:8181/question")
public interface feignQuestion {
	@RequestMapping(method = RequestMethod.GET)
    List<Question> getQuestions();
	
	
	@RequestMapping(value ="/{questionId}",method = RequestMethod.GET)
	Question getQuestionById(@PathVariable Integer questionId) ;
}


