package com.assignment.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="questions")
public class Questions {
	@Id
	@GeneratedValue
	private long id;
	private String questionId;
	private String heading;
	private String questiontype;
	private String totaloptions;
	private Integer min;
	private Integer max;
	private String ans;
}
