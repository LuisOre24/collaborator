package com.devloc.managementsof.repository;


import com.devloc.managementsof.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
}
