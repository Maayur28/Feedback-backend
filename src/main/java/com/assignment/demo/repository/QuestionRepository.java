package com.assignment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.demo.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Long> {

	Questions getByQuestionId(String questionId);

}
