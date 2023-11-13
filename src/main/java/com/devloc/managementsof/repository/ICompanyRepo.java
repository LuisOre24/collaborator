package com.devloc.managementsof.repository;


import com.devloc.managementsof.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepo extends JpaRepository<Company, Integer> {
}
