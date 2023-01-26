package com.assignment.demo.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionResponse {

	private String questionId;
	private String heading;
	private String questiontype;
	private List<String> questionOptions;
	private List<String> answers;
	private Integer min;
	private Integer max;
}
