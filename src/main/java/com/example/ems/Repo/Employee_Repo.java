package com.example.ems.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.Entity.Employee;

public interface Employee_Repo extends JpaRepository<Employee, Integer> {

}
