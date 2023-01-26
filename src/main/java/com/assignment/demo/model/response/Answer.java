package com.assignment.demo.model.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
	private String questionId;
	private List<String> answers;
}
