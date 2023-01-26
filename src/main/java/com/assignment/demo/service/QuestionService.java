package com.assignment.demo.service;

import com.assignment.demo.model.response.Answer;
import com.assignment.demo.model.response.QuestionResponse;

public interface QuestionService {

	QuestionResponse getQuestion(String questionNo) throws Exception;
	
	Integer getHappiness() throws Exception;

	QuestionResponse saveAnswer(Answer answer);
}