package com.inova.uni.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.inova.uni.entity.Department;


@EnableJpaRepositories
@Repository
public interface DepartmentRepo extends JpaRepository<Department,String> {

}
