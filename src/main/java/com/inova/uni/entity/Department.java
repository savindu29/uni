package com.inova.uni.entity;


import java.util.List;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="property_id")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="dept_head_name")
	private String deptHeadName;
	@OneToMany(mappedBy = "department")
	private List<Student> students;

}
