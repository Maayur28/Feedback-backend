package com.assignment.demo.model.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionsList {
	private List<QuestionResponse> questions;
}
