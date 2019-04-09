package com.revature.screenforce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.screenforce.beans.Question;
import com.revature.screenforce.services.QuestionService;

@RestController
@CrossOrigin
public class QuestionController {
	@Autowired
	QuestionService service;
	
//	@PostMapping(value = "/question")
//	public void postQuestion(@RequestParam Question q)
//	{
//		service.postQuestion(q);
//	}
	@GetMapping(value = "/question")
	public Question[] getQuestions()
	{
		System.out.println(service.getQuestions());
		Question[] q = service.getQuestions();
		System.out.println(q);
		return q;
	}
}
