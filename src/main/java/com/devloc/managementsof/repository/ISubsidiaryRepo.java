package com.devloc.managementsof.repository;

import com.devloc.managementsof.entity.Subsidiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubsidiaryRepo extends JpaRepository<Subsidiary, Integer> {
}
