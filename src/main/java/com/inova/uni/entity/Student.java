package com.inova.uni.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="property_id")
	private String student_id;
	@Column(name="full_name")
	private String fullname;
	@Column(name="gender")
	private String gender;
	@Column(name="birthday")
	private LocalDateTime birthday;
	@Column(name="mobile_no")
	private String mobileNo;
	@Column(name="address")
	private String address;
	@ManyToOne()
	@JoinColumn(name="dept_id")
	private Department department;
	@OneToMany(mappedBy = "student")
    private List<StudentModule> studentModules;

}
