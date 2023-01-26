package com.assignment.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.demo.action.QuestionsAction;
import com.assignment.demo.entity.Questions;
import com.assignment.demo.model.response.Answer;
import com.assignment.demo.model.response.QuestionResponse;
import com.assignment.demo.repository.QuestionRepository;
import com.assignment.demo.service.QuestionService;

@Service
public class QuestionServiceImpl extends QuestionsAction implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public QuestionResponse getQuestion(String questionNo) throws Exception {
		// TODO Auto-generated method stub
		Questions response = questionRepository.getByQuestionId(questionNo);
		QuestionResponse quesResponse = new QuestionResponse();
		quesResponse.setHeading(response.getHeading());
		quesResponse.setAnswers(createArrayListFromString(response.getAns()));
		quesResponse.setMax(response.getMax());
		quesResponse.setMin(response.getMin());
		quesResponse.setQuestionId(response.getQuestionId());
		quesResponse.setQuestionOptions(createArrayListFromString(response.getTotaloptions()));
		quesResponse.setQuestiontype(response.getQuestiontype());
		return quesResponse;
	}

	@Override
	public QuestionResponse saveAnswer(Answer answer) {
		// TODO Auto-generated method stub
		Questions response = questionRepository.getByQuestionId(answer.getQuestionId());
		QuestionResponse quesResponse = new QuestionResponse();
		if (response != null) {
			response.setAns(createStringFromList(answer.getAnswers()));
			response = questionRepository.save(response);
			quesResponse.setHeading(response.getHeading());
			quesResponse.setAnswers(createArrayListFromString(response.getAns()));
			quesResponse.setMax(response.getMax());
			quesResponse.setMin(response.getMin());
			quesResponse.setQuestionId(response.getQuestionId());
			quesResponse.setQuestionOptions(createArrayListFromString(response.getTotaloptions()));
			quesResponse.setQuestiontype(response.getQuestiontype());
		}
		return quesResponse;
	}

	@Override
	public Integer getHappiness() throws Exception {
		Integer happiness = 3;
		for (int i = 1; i <= 5; i++) {
			Questions response = questionRepository.getByQuestionId(String.valueOf(i));
			if (i == 1) {
				happiness = getRangeHappiness(response, happiness);
			} else if (i == 2) {
				happiness = getRadioHappiness(response, happiness);
			} else if (i == 4) {
				happiness = getCheckboxHappiness(response, happiness);
			} else if (i == 5) {
				happiness = getSelectHappiness(response, happiness);
			}
		}
		if (happiness < 0) {
			happiness = 0;
		} else if (happiness > 5) {
			happiness = 5;
		}
		return happiness;
	}

}
