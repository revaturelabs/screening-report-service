package com.revature.screenforce.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.screenforce.beans.Question;
import com.revature.screenforce.services.BucketClient;
import com.revature.screenforce.services.BucketService;
import com.revature.screenforce.services.QuestionClient;
import com.revature.screenforce.models.QuestionModel;
import com.revature.screenforce.beans.Question;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {
//	@Autowired
//	QuestionService service;
//	@Autowired
//	BucketService bService;
	
	BucketClient bucketClient = Feign.builder()
			  .client(new OkHttpClient())
			  .encoder(new GsonEncoder())
			  .decoder(new GsonDecoder())
			  .logger(new Slf4jLogger(BucketClient.class))
			  .logLevel(Logger.Level.FULL)
			  .target(BucketClient.class, "http://localhost:8080/admin/bucket");
	
	QuestionClient questionClient = Feign.builder()
			  .client(new OkHttpClient())
			  .encoder(new GsonEncoder())
			  .decoder(new GsonDecoder())
			  .logger(new Slf4jLogger(QuestionClient.class))
			  .logLevel(Logger.Level.FULL)
			  .target(QuestionClient.class, "http://localhost:8080/admin/question");
	
	@PostMapping(value = "/new")
	public Question postQuestion(@RequestBody String s)
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
			q.setSampleAnswer2(jn.get("sampleAnswer2").asText());
			q.setSampleAnswer3(jn.get("sampleAnswer3").asText());
			q.setSampleAnswer4(jn.get("sampleAnswer4").asText());
			q.setSampleAnswer5(jn.get("sampleAnswer5").asText());
			q.setQuestionId(0);
			q.setBucket(bucketClient.getBucketById(jn.get("bucket").asInt()));
			q.setIsActive(false);	
		} catch(Exception e)
		{
			e.printStackTrace(System.out);
		}
		return questionClient.createQuestion(q);
	}
	
	@GetMapping()
	public List<Question> getQuestions()
	{
		List<Question> questions = questionClient.getAllQuestions();		
		System.out.println(questions);
		return questions;
	}
}