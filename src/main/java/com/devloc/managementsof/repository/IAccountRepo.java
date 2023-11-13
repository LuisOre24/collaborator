package com.devloc.managementsof.repository;


import com.devloc.managementsof.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account, Integer> {
}
