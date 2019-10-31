package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.screenforce.beans.Question;

/**
 * The feignClient for question Takes Data from the screening-admin-service,
 * QuestionController
 * 
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 *
 */

@FeignClient(name = "question", url = "http://localhost:8181/question")
public interface FeignQuestion {
	@RequestMapping(method = RequestMethod.GET)
	List<Question> getQuestions();

	@RequestMapping(value = "/{questionId}", method = RequestMethod.GET)
	Question getQuestionById(@PathVariable Integer questionId);
}
