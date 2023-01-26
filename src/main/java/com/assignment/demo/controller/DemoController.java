package com.assignment.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.demo.model.response.Answer;
import com.assignment.demo.service.QuestionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DemoController {
	@Autowired
	QuestionService questionService;

	@RequestMapping(value = "/getquestion/{questionNo}", method = RequestMethod.GET)
	public ResponseEntity<?> getQuestion(@PathVariable String questionNo) throws Exception {
		try {
			return ResponseEntity.ok(questionService.getQuestion(questionNo));
		} catch (Exception e) {
			return new ResponseEntity<>("Sorry questions are not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/gethappiness", method = RequestMethod.GET)
	public ResponseEntity<?> getHappiness() throws Exception {
		try {
			return ResponseEntity.ok(questionService.getHappiness());
		} catch (Exception e) {
			return new ResponseEntity<>("Sorry questions are not found", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/addanswer", method = RequestMethod.POST)
	public ResponseEntity<?> updateQuestion(@RequestBody Answer answer) throws Exception {
		try {
			return ResponseEntity.ok(questionService.saveAnswer(answer));
		} catch (Exception e) {
			return new ResponseEntity<>("Please try again later", HttpStatus.BAD_GATEWAY);
		}
	}
}
