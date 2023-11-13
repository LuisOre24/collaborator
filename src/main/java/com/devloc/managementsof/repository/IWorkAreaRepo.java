package com.devloc.managementsof.repository;


import com.devloc.managementsof.entity.WorkArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWorkAreaRepo extends JpaRepository<WorkArea, Integer> {
}
