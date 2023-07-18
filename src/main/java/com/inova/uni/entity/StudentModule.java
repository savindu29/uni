package com.inova.uni.entity;

import java.util.Date;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity()
@Table(name="student_module")
public class StudentModule {
	@Id
	@Column(name="property_id")
	private String id;
	@ManyToOne()
	@JoinColumn(name="student_id")
	private Student  student;
	@ManyToOne()
	@JoinColumn(name="lecturer_id ")
	private Lecture lecture;
	@ManyToOne()
	@JoinColumn(name="module_id")
	private Module module;
	@Column(name="semester_number")
	private String semesterNumber;

}
