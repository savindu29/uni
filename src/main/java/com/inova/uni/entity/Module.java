package com.inova.uni.entity;

import java.util.List;
import lombok.*;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="module")
public class Module {
	@Id
	@Column(name="property_id")
	private String id;
	@Column(name="credit_course")
	private boolean creditCourse;
	@Column(name="no_of_credit")
	private int noOfCredit;
	
	@OneToMany(mappedBy = "module")
    private List<StudentModule> studentModules;

}
