package com.revature.screenforce.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.screenforce.beans.Question;


public interface QuestionClient {
	public Question createQuestion(@Valid @RequestBody Question question);
	
	public List<Question> getAllQuestions();
	
	public Question getQuestionById( int questionId);
}
