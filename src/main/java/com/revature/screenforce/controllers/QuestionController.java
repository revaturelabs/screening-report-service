package com.revature.screenforce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.screenforce.beans.Question;
import com.revature.screenforce.services.BucketService;
import com.revature.screenforce.services.QuestionService;

@RestController
@CrossOrigin
public class QuestionController {
	@Autowired
	QuestionService service;
	@Autowired
	BucketService bService;
	
	@PostMapping(value = "/question")
	public void postQuestion(@RequestBody String s)
	{
		ObjectMapper mapper = new ObjectMapper();
		Question q = new Question();
		JsonNode jn;
		int acc_id;
		int camp_id;
		try {
			jn = mapper.readTree(s);
			q.setQuestionText(jn.get("questionText").asText());
			q.setSampleAnswer1(jn.get("sampleAnswer1").asText());
			q.setSampleAnswer2(jn.get("sampleAnswer1").asText());
			q.setSampleAnswer3(jn.get("sampleAnswer1").asText());
			q.setSampleAnswer4(jn.get("sampleAnswer1").asText());
			q.setSampleAnswer5(jn.get("sampleAnswer1").asText());
			q.setQuestionId(0);
			q.setBucket(bService.getBucket(jn.get("bucket").asInt()));
			q.setIsActive(false);
			
			
		} catch(Exception e)
		{
			e.printStackTrace(System.out);
		}
		service.postQuestion(q);
	}
	@GetMapping(value = "/question")
	public Question[] getQuestions()
	{
		System.out.println(service.getQuestions());
		Question[] q = service.getQuestions();
		System.out.println(q);
		return q;
	}
	
}
