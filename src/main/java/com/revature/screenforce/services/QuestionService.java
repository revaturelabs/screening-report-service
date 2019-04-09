package com.revature.screenforce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.beans.Question;
import com.revature.screenforce.beans.QuestionScore;
import com.revature.screenforce.daos.QuestionDAO;

@Service
public class QuestionService {
	@Autowired
	QuestionDAO question;
	
	// Purpose of this service is to post and get questions from the front end
	// not to get all the data inside a question, that has nothing to do with the question
	// (such as buckets and screeners)
	public void postQuestion(Question q)
	{
		System.out.println(q);
		question.save(q);
	}
	public Question[] getQuestions() {
		Question[] q = new Question[question.findAll().size()];
		q = question.findAll().toArray(q);
		Question[] mock = new Question[q.length];
		for(int x = 0; x < mock.length; x++)
		{
			mock[x] = new Question();
			mock[x].setQuestionId(q[x].getQuestionId());
			mock[x].setQuestionText(q[x].getQuestionText());
			mock[x].setSampleAnswer1(q[x].getSampleAnswer1());
			mock[x].setSampleAnswer2(q[x].getSampleAnswer2());
			mock[x].setSampleAnswer3(q[x].getSampleAnswer3());
			mock[x].setSampleAnswer4(q[x].getSampleAnswer4());
			mock[x].setSampleAnswer5(q[x].getSampleAnswer5());
		}
		
		//System.out.println(q);
		return mock;
	}
}
