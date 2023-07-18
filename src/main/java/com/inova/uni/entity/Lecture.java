package com.inova.uni.entity;


import java.util.List;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="lecture")
public class Lecture {
	@Id
	@Column(name="property_id")
	private String id;
	@Column(name="full_name")
	private String fullName;
	@Column(name="emp_no")
	private String empNo;
	@Column(name="mobile_no")
	private String mobileNo;
	@Column(name="basic_salary")
	private double basicSalary;
	
	@OneToMany(mappedBy = "lecture")
    private List<StudentModule> studentModules;

}
