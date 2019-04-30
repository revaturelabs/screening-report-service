package com.revature.screenforce.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.screenforce.beans.Question;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface QuestionClient {
	@RequestLine("POST")
	@Headers("Content-Type: application/json")
	public Question createQuestion(@Valid @RequestBody Question question);
	
	@RequestLine("GET")
	public List<Question> getAllQuestions();
	
	@RequestLine("GET /{questionId}")
	public Question getQuestionById(@Param("questionId") int questionId);
}
