package com.devloc.managementsof.repository;


import com.devloc.managementsof.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepo extends JpaRepository<Position, Integer> {
}
